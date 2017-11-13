FROM gersua/openjdk8-ubuntu:latest
MAINTAINER Grupo AES
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/rest-service-admon-convenios.jar .
ENTRYPOINT java -jar rest-service-admon-convenios.jar
