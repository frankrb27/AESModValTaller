FROM gersua/openjdk8-ubuntu:latest
MAINTAINER Grupo AES
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/rest-service-utilitario.jar .
ENTRYPOINT java -jar rest-service-utilitario.jar
EXPOSE 9050