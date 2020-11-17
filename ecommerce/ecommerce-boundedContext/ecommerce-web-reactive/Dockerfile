####################
### Java Builder ###
####################


# https://springframework.guru/manage-docker-containers-with-docker-compose/
FROM openjdk:11
ARG JAR_FILE=target/*.jar
#ADD ./target/ecommerce-web-reactive-0.0.1-SNAPSHOT.jar /usr/src/ecommerce-web-reactive-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} appreactive.jar
#WORKDIR usr/src
#ENTRYPOINT ["java","-jar", "ecommerce-web-reactive-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","/appreactive.jar"]
EXPOSE 8887

