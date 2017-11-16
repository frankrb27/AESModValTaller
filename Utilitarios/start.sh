mvn clean package
docker build -t rest-service-utilitario .
docker run -d -p 9050:8080 --name rest-service-utilitario rest-service-utilitario
