mvn clean package
docker build -t sap-service-authorization .
docker run -d -p 9010:8080 --name sap-service-authorization sap-service-authorization
