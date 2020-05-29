# Indicadores económicos - API

Proyecto backend que permite consumir API [https://www.indecon.online](https://www.indecon.online) con indicadores económicos.

El objetivo de la aplicación es actuar como un wrapper de la API principal y guardar los resultados en caché para poder hacer más rápido el acceso a la información.
Además sirve en caso de que las API tengan una cuota de uso.

## Tecnología

El proyecto se creo utilizando [spring initializr](https://start.spring.io/) 

* Java 8
* Maven 3 (proyecto viene con maven wrapper)

### Dependencias en proyecto

* Spring boot starter web
* Spring boot starter tomcat
* Spring boot starter cache
* Spring boot starter test
* Lombok (para evitar repetir código)
* Caffeine (manejo de cache)
* Gson (para manejo de objetos json)

## Configuración

Servidor embebido se levanta en puerto `8889`, para poder cambiar el puerto se puede hacer en archivo `src/main/resources/application.properties` en propiedad `server.port`

Tiempo de vida del caché se puede ver y modificar en clase `src/main/java/com/maurofokker/demo/config/CaffeineCacheConfig.java`

```java
Caffeine<Object, Object> caffeineCacheBuilder() {
    return Caffeine.newBuilder()
            .expireAfterWrite(30, TimeUnit.MINUTES);
}
```

## Ejecución

Existen archivos wrapper de maven (`mvnw` para linux y `mvnw.cmd` para windows) que se pueden usar en caso de no tener maven instalado. 
Esto permitirá manejar las dependencias del proyecto (en archivo `pom.xml`), correr test, empaquetar aplicativo y ejecutarlo.

* Descarga de dependencias, test y empaquetado de aplicación en directorio `target`

`$ mvn clean package`

* Para correr en modo desarrollo

`$ mvn spring-boot:run` 

* Para correr como aplicación stand alone

  - `$ mvn clean package spring-boot:repackage`
  - `java -jar target/indicators-api-0.0.1-SNAPSHOT.war`