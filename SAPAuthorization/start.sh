mvn clean package
docker build -t sap-service-authorization .
docker run -d -p 8080:8080 --name sap-service-authorization sap-service-authorization
