mvn clean package
docker build -t rest-service-admon-facturas .
docker run -d -p 9010:8080 --name rest-service-admon-facturas rest-service-admon-facturas
