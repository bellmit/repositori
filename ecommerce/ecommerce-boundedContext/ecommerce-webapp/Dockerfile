# https://springframework.guru/manage-docker-containers-with-docker-compose/
FROM openjdk:11
ARG JAR_FILE=target/*.jar
#ADD ./target/ecommerce-webapp-4.4.3-SNAPSHOT.jar /usr/src/ecommerce-webapp-4.4.3-SNAPSHOT.jar
COPY ${JAR_FILE} appwebapp.jar
#WORKDIR usr/src
#ENTRYPOINT ["java","-jar", "ecommerce-webapp-4.4.3-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","/appwebapp.jar"]
EXPOSE 8888
