mvn clean package
docker build -t rest-service-admon-compensacion .
docker run -d -p 9020:8080 --name rest-service-admon-compensacion rest-service-admon-compensacion
