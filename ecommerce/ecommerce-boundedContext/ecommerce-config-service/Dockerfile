FROM openjdk:11
ENV APP_HOME /app
WORKDIR $APP_HOME
EXPOSE 8088
COPY target/*.jar /app/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c"]
CMD ["exec java $JAVA_OPTS -jar app.jar"]
