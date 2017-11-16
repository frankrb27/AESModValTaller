FROM gersua/openjdk8-ubuntu:latest
MAINTAINER Grupo AES
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/rest-service-admon-cuentas.jar .
ENTRYPOINT java -jar rest-service-admon-cuentas.jar
EXPOSE 9040