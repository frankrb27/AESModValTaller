mvn clean package
docker build -t rest-service .
docker run -d -p 9010:8080 --name rest-service-admon-convenios rest-service-admon-convenios
