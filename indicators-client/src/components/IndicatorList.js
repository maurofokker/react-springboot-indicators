import React, { Component } from 'react';
import {
  Card,
  CardSubtitle,
  CardText,
  Container,
  Row,
  Col,
  CardBody,
  CardHeader,
  CardFooter,
} from 'reactstrap';
import { Link } from 'react-router-dom';
import Loader from 'react-loader-spinner';
import { getLastIndicators } from '../services/indicators';

class IndicatorList extends Component {
  state = {
    isLoading: true,
    isError: false,
    indicators: [],
    mapUnit: { pesos: 'CLP', dolar: 'USD', euro: 'EU', porcentual: '%' },
  };

  async componentDidMount() {
    getLastIndicators()
      .then((indicators) =>
        this.setState({
          indicators: Object.values(indicators),
          isLoading: false,
        })
      )
      .catch((error) => {
        console.log('ERROR', error);
        this.setState({ ...this.state, isLoading: false, isError: true });
      });
  }

  parseDate(intDate) {
    let date = new Date(1000 * intDate);
    return this.prettyDate(date);
  }

  prettyDate(date) {
    let months = [
      'Enero',
      'Febrero',
      'Marzo',
      'Abril',
      'Mayo',
      'Junio',
      'Julio',
      'Agosto',
      'Septiembre',
      'Octubre',
      'Noviembre',
      'Diciembre',
    ];

    return (
      months[date.getUTCMonth()] +
      ' ' +
      date.getUTCDate() +
      ', ' +
      date.getUTCFullYear()
    );
  }

  render() {
    const { indicators, isLoading, mapUnit, isError } = this.state;

    /*
    if (isLoading) {
      return (
        <div aria-label="loading">
          <Loader type="Circles" color="#00BFFF" height={80} width={80} />
        </div>
      );
    }

    if (isError) {
      return (
        <div aria-label="error">
          Ha ocurrido un error al traer los indicadores
        </div>
      );
    }
*/
    return (
      <>
        <Container className="themed-container" fluid="sm">
          <Row>
            <Col style={{ padding: '15px' }} className="text-center">
              <div>
                <p className="h3">Indicadores Económicos</p>
              </div>
              <div role="alert" aria-live="polite">
                {isLoading ? (
                  <Loader
                    type="Circles"
                    color="#00BFFF"
                    height={80}
                    width={80}
                  />
                ) : isError ? (
                  'Ha ocurrido un error al traer los indicadores'
                ) : null}
              </div>
            </Col>
          </Row>
          {indicators ? (
            <Row className="no-gutters">
              {indicators.map((indicator) => (
                <Col sm="6" key={indicator.key} style={{ padding: '5px' }}>
                  <Link
                    style={{ textDecoration: 'none' }}
                    to={`/indicators/${indicator.key}`}
                  >
                    <Card body outline color="info">
                      <CardHeader>{indicator.key.toUpperCase()}</CardHeader>
                      <CardBody style={{ minHeight: '120px' }}>
                        <CardSubtitle className="mb-2 text-muted">
                          {indicator.name}
                        </CardSubtitle>
                        <CardText className="text-right">
                          {indicator.value} {mapUnit[indicator.unit]}
                        </CardText>
                      </CardBody>
                      <CardFooter>
                        <small className="text-muted">
                          Última actualización {this.parseDate(indicator.date)}
                        </small>
                      </CardFooter>
                    </Card>
                  </Link>
                </Col>
              ))}
            </Row>
          ) : null}
        </Container>
      </>
    );
  }
}

export default IndicatorList;
