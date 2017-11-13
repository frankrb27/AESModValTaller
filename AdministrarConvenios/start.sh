mvn clean package
docker build -t rest-service-admon-convenios .
docker run -d -p 9000:8080 --name rest-service-admon-convenios rest-service-admon-convenios
