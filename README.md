# Indicadores Económicos

Aplicación full stack para el consumo de API [https://www.indecon.online](https://www.indecon.online) con indicadores económicos.

## Tecnología utilizada

- FRONT: React (`indicators-client`)
- BACK: Spring Boot (`indicators-api`)

La aplicacion `indicators-client` consume dos API dispuestas por `indicators-api` quien a su vez realiza la integración con [https://www.indecon.online](https://www.indecon.online)

`indicators-client` en su página principal despliega los últimos indicadores económicos, cada indicador puede ser clickeado para ir a una nueva página en la que se despliega un gráfico lineal con un histórico de valores asociados a dicho indicador.

`indicators-api` funciona como un wrapper de [https://www.indecon.online](https://www.indecon.online) cuyo rol principal es guardar resultados en caché para hacer más rápido el acceso sobre todo a los valores históricos de los indicadores. En caso de que la API tuviera cuota de uso, esta opción es relevante sobre todo si los datos no cambian seguido.

Para el correcto uso de la aplicación se debe ejecutar en siguiente orden:

1. `indicators-api`
2. `indicators-client`

Más información sobre tecnología y modo de ejecución en el README de cada proyecto.
