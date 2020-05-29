# Indicadores económicos - Cliente

Proyecto front que permite mostrar indicadores ecónomicos obtenidos desde aplicación en backend.

## Tecnología

El proyecto se creó utilizando `create-react-app` por lo que se recomienda tener la última versión de `node` y `yarn`, este último es utilizado por defecto

Al momento de desarrollo se contaba con las siguientes versiones

- Node: `v12.16.3`
- Yarn: `1.22.4`

Tecnologías en proyecto

- React
- React Router
- Recharts
- Reactstrap
- Bootstrap
- Test => Jest y React-Testing-Library

Se desarrolla un componente utilizando Clases y otro como componente funcional para el uso de `hooks`

## Prerequisito

Este proyecto se encuentra ligado a un backend que debe estar ejecutandose para poder consumir API [https://www.indecon.online](https://www.indecon.online)

La aplicación backend se llama `indicators-api`, construida utilizando Spring Boot y que se encuentra paralelo a este repositorio.

Para ejecutar aplicación se requiere tener instalado lo siguiente:

- Java: versión 8
- Maven: versión 3 (se desarrolla con `Apache Maven 3.5.2`)

Aplicación back está configurada para correr en puerto `8889`, si requiere hacer cambios se puede modificar archivo de propiedades de backend

Más información en su README.

## Scripts de ejecución aplicación

Dentro del directorio del proyecto se pueden ejecutar comandos asociados a `yarn` para inicializar aplicación, correr tests, construit aplicación para producción.

### `yarn install`

Para instalar módulos asociados a desarrollo

### `yarn start`

Inicializa la aplicación, que se puede ver en el browser en ruta [http://localhost:3000](http://localhost:3000)

### `yarn test`

Lanza test en modo interactivo

### `yarn build`

Contruye la aplicación para producción en directorio `build`.
