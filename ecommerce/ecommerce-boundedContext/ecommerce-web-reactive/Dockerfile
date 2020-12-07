####################
### Java Builder ###
####################


# https://springframework.guru/manage-docker-containers-with-docker-compose/
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appreactive.jar
#WORKDIR usr/src
ENTRYPOINT ["java","-jar","/appreactive.jar"]
EXPOSE 8887

