mvn clean package
docker build -t rest-service-admon-cuentas .
docker run -d -p 9040:8080 --name rest-service-admon-cuentas rest-service-admon-cuentas
