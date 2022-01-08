# https://github.com/roaugusto/spring-microservices-new/blob/master/gateway-service/Dockerfile 
FROM openjdk:11
#FROM openjdk:8-jre-alpine
ENV APP_HOME /app
WORKDIR $APP_HOME
COPY target/*.jar /app/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c"]
CMD ["exec java $JAVA_OPTS -jar app.jar"]
