####################
### Java Builder ###
####################


# https://springframework.guru/manage-docker-containers-with-docker-compose/
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/ecommerce-web-reactive-4.4.3-SNAPSHOT.jar appreactive.jar
#WORKDIR usr/src
ENTRYPOINT ["java","-jar","/appreactive.jar"]
EXPOSE 8887

