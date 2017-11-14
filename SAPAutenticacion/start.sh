mvn clean package
docker build -t sap-autenticacion .
docker run -d -p 9030:8080 --name sap-autenticacion sap-autenticacion
