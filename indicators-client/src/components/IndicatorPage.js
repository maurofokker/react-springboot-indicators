import React, { useState, useEffect } from 'react';
import { useParams, useHistory } from 'react-router-dom';
import { Container, Row, Col, Button } from 'reactstrap';
import {
  LineChart,
  CartesianGrid,
  XAxis,
  YAxis,
  Legend,
  Line,
  Tooltip,
  ResponsiveContainer,
} from 'recharts';
import Loader from 'react-loader-spinner';
import { getValuesForIndicator } from '../services/indicators';

function IndicatorPage() {
  const [indicator, setIndicator] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);
  const [data, setData] = useState([]);
  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    setIsError(false);
    setIsLoading(true);
    getValuesForIndicator(id)
      .then((indicator) => {
        const dataArray = [];
        Object.entries(indicator.values).map(([k, v], i) =>
          dataArray.push({
            fecha: new Date(Number(k) * 1000).toLocaleDateString(),
            valor: v,
          })
        );
        setData(dataArray);
        setIndicator(indicator);
      })
      .catch((err) => {
        setIsError(true);
        setIndicator(null);
      })
      .finally(() => setIsLoading(false));
  }, [id]);

  function handleClick() {
    history.push('/');
  }

  return (
    <Container className="themed-container" fluid={true}>
      <Row>
        <Col style={{ padding: '25px' }} className="text-center">
          <div role="alert" aria-live="polite">
            {isLoading ? (
              <Loader type="Circles" color="#00BFFF" height={80} width={80} />
            ) : isError ? (
              'Ha ocurrido un error al traer los indicadores'
            ) : null}
          </div>
          {indicator ? (
            <>
              <Row>
                <Col>
                  <div>
                    <p className="h3">
                      Gráfico histórico de indicador{' '}
                      {indicator.key.toUpperCase()}
                    </p>
                    <p>{indicator.name}</p>
                  </div>
                </Col>
              </Row>
              <Row>
                <Col>
                  <>
                    <ResponsiveContainer width="100%" height={400}>
                      <LineChart
                        width={730}
                        height={250}
                        data={data}
                        margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
                      >
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="fecha" interval="preserveEnd" />
                        <YAxis interval="preserveEnd" />
                        <Tooltip />
                        <Legend />
                        <Line
                          type="monotone"
                          dataKey="valor"
                          stroke="#8884d8"
                          activeDot={{ r: 8 }}
                        />
                      </LineChart>
                    </ResponsiveContainer>
                  </>
                </Col>
              </Row>
            </>
          ) : null}

          <Button color="link" onClick={handleClick}>
            Volver
          </Button>
        </Col>
      </Row>
    </Container>
  );
}

export default IndicatorPage;
