# README #

Este proyecto implementa el servicio obtención de los mensajes de la placa Arduino MKRFOX 1200. El envío es implementado mediante la red Sigfox (ver www.sigfox.com/en).

## OBJETIVO DEL REPOSITORIO ##

Este repositorio es usado para la gestión del ciclo de vida y las versiones del servicio de obtención de los mensajes sigfox 

Los datos incluidos en estos mensajes son:
* DevideID
* Metadatos de la señal enviada (por ejemplo relación señal a ruido)
* Coordenadas de geolocalizacion del dispositivo

## CONFIGURACIÓN ##

Este proyecto se implementa como una aplicación de Spring Boot construida mediante maven.

Para la complicación del proyecto:

* mvn clean install

Para ejecutar el proyecto:

* java -jar sigfox-boot-0.0.1-SNAPSHOT.jar

### Conexión a Heroku ###

Los datos de conexión y despliegue a heroku son:

* Host
    * ec2-54-75-244-248.eu-west-1.compute.amazonaws.com
* Database
    * d9n4pkcd0ismmi
* Port
    * 5432
* URI
    * postgres://grxrjgduyrogvs:dc87ed052bc2c00c1821cce5daaef9b5264c45703e30c379df5477a0787adbf3@ec2-54-75-244-248.eu-west-1.compute.amazonaws.com:5432/d9n4pkcd0ismmi
* Heroku CLI
    * heroku pg:psql postgresql-clear-68549 --app sigfox-service


## ESTRUCTURA DEL PROYCTO ##

El proyecto esta estructurado en diferentes módulos maven que siguen la siguiente estructura:

* **sigfox-boot**: Configuración de Spring Boot
* **sigfox-web**: Implementación de la capa web del proyecto, implementa el API definido que da acceso a los servicios desarrollados.

## PRUEBAS DE HUMO ##

La ejecución de las pruebas de humo se implementa mediante una colección de pruebas de Postman (ver www.getpostman.com)

***Not Yet Implemented***

### Configuracion de Entorno para Ejecución de Pruebas de Humo ###

***Not Yet Implemented***

### Ejecución de pruebas de humo mediante Newman ###

Para ejecutar la colección de pruebas es necesario instalar newman. Para la instalación de newman en windows es necesario tener instalado NodeJs y ejecutar el comando:

* npm install -g newman

Para la ejecución de la colección en local se deben seguir los siguientes pasos:

***Not Yet Implemented***

