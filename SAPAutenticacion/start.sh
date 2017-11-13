mvn clean package
docker build -t sap-autenticacion .
docker run -d -p 7070:8080 --name sap-autenticacion sap-autenticacion