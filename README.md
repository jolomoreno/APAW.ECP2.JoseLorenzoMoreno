# Asignatura: *Arquitectura y Patrones para Aplicaciones Web*
> Proyecto para la segunda práctica de la asignatura Arquitectura y Patrones para Aplicaciones Web.
> Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código
> #### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

## Estado del proyecto

#### Master: 
#### [![Build Status](https://travis-ci.org/jolomoreno/APAW.ECP2.JoseLorenzoMoreno.svg?branch=master)](https://travis-ci.org/jolomoreno/APAW.ECP2.JoseLorenzoMoreno)

#### Develop:
#### [![Build Status](https://travis-ci.org/jolomoreno/APAW.ECP2.JoseLorenzoMoreno.svg?branch=develop)](https://travis-ci.org/jolomoreno/APAW.ECP2.JoseLorenzoMoreno)

#### [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=jolomoreno_APAW.ECP2.JoseLorenzoMoreno&metric=alert_status)](https://sonarcloud.io/dashboard?id=jolomoreno_APAW.ECP2.JoseLorenzoMoreno)

## Tecnologías necesarias
* Java
* Maven
* IntelliJ
* GitHub
* Travis CI
* Sonarcloud

## Diseño de entidades
![equipos-entities-diagram](https://github.com/jolomoreno/APAW.ECP2.JoseLorenzoMoreno/blob/master/docs/APAW.ECP2.JoseLorenzoMoreno.png)

## Arquitectura
![equipos-architecture-diagram](https://github.com/miw-upm/APAW-themes-layers/blob/develop/docs/themes-architecture-diagram.png)

## Responsabilidades
#### Dispatcher
* Centraliza las peticiones y hace de repartidor
* Recupera los datos de la petición y los pasa como parámetros de método
* Captura las excepciones y las convierte en errores Http
#### restControllers
* Define el path del recurso
* Valida la entrada
* Traspasa la petición a los controladores de la capa de negocio
#### businessControllers
* Procesa la petición, apoyándose en los DAO’s
* Crea las entidades a partir de los DTO’s
* Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
#### daos
* Gestionan la BD
#### entities
* Son las entidades persistentes en la BD

## API
### POST /competiciones
#### Parámetros del cuerpo
- `fecha`: LocalDatetime (**requerido**)
- `lugar`: String (**requerido**)
#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
---
### GET /competiciones
#### Respuesta
- 200 OK 
  - `[ {id:String,fecha:LocalDateTime,lugar:String} ]`
---
### PUT /competiciones/{id}
#### Parámetros del cuerpo
- `fecha`: LocalDatetime (**requerido**)
- `lugar`: String (**requerido**)
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### DELETE /competiciones/{id}
#### Respuesta
- 200 OK 
---
### POST /equipos
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
- `numCorredores`: Integer
- `categoria`: Categoria
- `competicionId`: String
#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /equipos
#### Respuesta
- 200 OK 
  - `[ {id:String,nombre:String} ]`
---
### PATCH /equipos/{id}/categoria
#### Parámetros del cuerpo
- `categoria`: String (**requerido**)
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /equipos/search?q=numCorredores:>=10
#### Respuesta
- 200 OK
  - `[ {id:String,nombre:String} ]`
- 403 BAD_REQUEST
---
##### Autor: Jose Lorenzo Moreno U.P.M.
