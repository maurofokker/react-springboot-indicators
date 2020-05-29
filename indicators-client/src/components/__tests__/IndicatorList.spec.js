import React from 'react';
import { getLastIndicators } from '../../services/indicators';
import IndicatorList from '../IndicatorList';
import { render, screen, wait, waitForElement } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';

const indicators = {
  cobre: {
    key: 'cobre',
    name: 'Precio del Cobre, dólares por libra',
    unit: 'dolar',
    date: 1584489600,
    value: 2.39,
  },
  dolar: {
    key: 'dolar',
    name: 'Dólar observado',
    unit: 'pesos',
    date: 1584489600,
    value: 855.09,
  },
  euro: {
    key: 'euro',
    name: 'Euro',
    unit: 'pesos',
    date: 1584489600,
    value: 938.42,
  },
  ipc: {
    key: 'ipc',
    name: 'Indice de Precios al Consumidor (Var. c/r al período anterior)',
    unit: 'porcentual',
    date: 1577836800,
    value: 1.1,
  },
  ivp: {
    key: 'ivp',
    name: 'Indice de valor promedio',
    unit: 'pesos',
    date: 1586390400,
    value: 29706.22,
  },
  oro: {
    key: 'oro',
    name: 'Precio del Oro, dólares por onza',
    unit: 'dolar',
    date: 1584576000,
    value: 1473.2,
  },
  plata: {
    key: 'plata',
    name: 'Precio de la Plata, dólares por onza',
    unit: 'dolar',
    date: 1584576000,
    value: 11.69,
  },
  uf: {
    key: 'uf',
    name: 'Unidad de fomento',
    unit: 'pesos',
    date: 1586390400,
    value: 28630.63,
  },
  utm: {
    key: 'utm',
    name: 'Unidad tributaria mensual',
    unit: 'pesos',
    date: 1583020800,
    value: 50021.0,
  },
  yen: {
    key: 'yen',
    name: 'Yen',
    unit: 'dolar',
    date: 1584489600,
    value: 107.33,
  },
};

jest.mock('../../services/indicators');

afterEach(() => {
  jest.resetAllMocks();
});

test('should load last economic indicators values', async () => {
  getLastIndicators.mockResolvedValueOnce(indicators);

  const { getByText, getByRole } = render(
    <BrowserRouter>
      <IndicatorList />
    </BrowserRouter>
  );

  expect(getByRole('alert')).toBeInTheDocument();

  const resolvedValue = await waitForElement(() => getByText(/ivp/i));
  expect(resolvedValue).toHaveTextContent(/ivp/i);
  expect(getLastIndicators).toHaveBeenCalledTimes(1);
  Object.keys(indicators).forEach((indicator) =>
    expect(getByText(indicator.toUpperCase())).toBeInTheDocument()
  );
});

test('should show loading spinner', async () => {
  getLastIndicators.mockResolvedValueOnce(indicators);

  const { getByRole } = render(
    <BrowserRouter>
      <IndicatorList />
    </BrowserRouter>
  );

  expect(getByRole('alert')).toBeInTheDocument();
  await wait();
});

test('show error if there is a problem getting indicators', async () => {
  const message = 'Ha ocurrido un error al traer los indicadores';

  getLastIndicators.mockRejectedValueOnce({ message });
  const { getByRole } = render(
    <BrowserRouter>
      <IndicatorList />
    </BrowserRouter>
  );
  expect(getLastIndicators).toHaveBeenCalledTimes(1);

  expect(getByRole('alert')).toBeInTheDocument();

  const alert = getByRole('alert');
  await wait(() => expect(alert).toHaveTextContent(message));
});
