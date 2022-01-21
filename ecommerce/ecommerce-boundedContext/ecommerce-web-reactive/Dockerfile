FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appreactive.jar
ENTRYPOINT ["java","-jar","/appreactive.jar"]
EXPOSE 8887

