# https://springframework.guru/manage-docker-containers-with-docker-compose/

# https://www.baeldung.com/dockerizing-spring-boot-application
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config.jar
ENTRYPOINT ["java","-jar","/config.jar"]
EXPOSE 8889
