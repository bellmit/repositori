# https://springframework.guru/manage-docker-containers-with-docker-compose/

# https://www.baeldung.com/dockerizing-spring-boot-application
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka.jar
ENTRYPOINT ["java","-jar","/eureka.jar"]
EXPOSE 8761
