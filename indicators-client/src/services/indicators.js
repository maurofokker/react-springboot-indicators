export const getLastIndicators = () => {
  return fetch('/indicators')
    .then((res) => res.json())
    .catch((e) => {
      throw e;
    });
};

export const getValuesForIndicator = (id) => {
  console.log('REQUEST for id: ', id);
  return fetch(`/indicators/${id}`)
    .then((res) => res.json())
    .catch((e) => {
      throw e;
    });
};
