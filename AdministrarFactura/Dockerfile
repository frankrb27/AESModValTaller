FROM gersua/openjdk8-ubuntu:latest
MAINTAINER Grupo AES
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/rest-service-admon-facturas.jar .
ENTRYPOINT java -jar rest-service-admon-facturas.jar
EXPOSE 9010