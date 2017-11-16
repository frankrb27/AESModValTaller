FROM gersua/openjdk8-ubuntu:latest
MAINTAINER Grupo AES
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/sap-service-authorization.jar .
ENTRYPOINT java -jar sap-service-authorization.jar
EXPOSE 8080
