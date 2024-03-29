####################
### Java Builder ###
####################
FROM maven:3.6.3-jdk-11 as java-builder


# Since we want to execute the mvn command with RUN (and not when the container gets started),
# we have to do here some manual setup which would be made by the maven's entrypoint script
#RUN mkdir -p /root/.m2 \
#    && mkdir /root/.m2/repository
# Copy maven settings, containing repository configurations


RUN mkdir -p /build
WORKDIR /build

COPY pom.xml /build/pom.xml
RUN mvn -B -f /build/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve

COPY settings.xml /usr/share/maven/ref/repository

#RUN mvn -B dependency:resolve dependency:resolve-plugins

# copy all but Angular source in
COPY src/main/java /build/src/main/java
COPY src/main/resources /build/src/main/resources
COPY src/test /build/src/test




#COPY --from=node-builder build/dist /build/src/main/resources/static

RUN mvn package

####################
### Java Runtime ###
####################
FROM openjdk:8-jdk-slim as runtime

ENV APP_HOME /app
ENV JAVA_OPTS=""

RUN mkdir $APP_HOME &&\
    mkdir $APP_HOME/config &&\
    mkdir $APP_HOME/log

WORKDIR $APP_HOME

RUN echo $JAVA_OPTS

COPY --from=java-builder /build/target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]