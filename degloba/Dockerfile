####################
###  Node Setup  ###
####################
#FROM node:10.13-alpine as node-angular-cli
#Linux setup
#RUN apk update \
#  && apk add --update alpine-sdk \
#  && apk del alpine-sdk \
#  && rm -rf /tmp/* /var/cache/apk/* *.tar.gz ~/.npm \
#  && npm cache verify \
#  && sed -i -e "s/bin\/ash/bin\/sh/" /etc/passwd

#Angular CLI
#RUN npm install -g @angular/cli@8.0.3

####################
### Node Builder ###
####################
#FROM node-angular-cli as node-builder

#RUN mkdir -p /build

#COPY /src/main/ng/fxui /build/src

#WORKDIR /build/src

#RUN npm rebuild node-sass &&\
#    npm install &&\
#    ng build --prod --output-path ../dist

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

#COPY degloba-domain /build/degloba-parent
#COPY degloba-domain /build/degloba-domain
#COPY degloba-domain /build/degloba-ioc-spring
#COPY degloba-domain /build/degloba-persistence
#COPY degloba-domain /build/degloba-integration
#COPY degloba-domain /build/degloba-utilitats
#COPY degloba-domain /build/degloba-cqrs
#COPY degloba-domain /build/degloba-infrastructure
#COPY degloba-domain /build/degloba-security
#COPY degloba-domain /build/degloba-ioc-test
#COPY degloba-domain /build/degloba-event-api
#COPY degloba-domain /build/degloba-facade
#COPY degloba-domain /build/degloba-webapp


#RUN mkdir -p /build
#WORKDIR /build
#COPY pom.xml /build

#RUN mvn -B -f /build/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
#RUN mvn -B -f /build/pom.xml  dependency:resolve

#COPY settings.xml /usr/share/maven/ref/

#RUN mvn -B dependency:resolve dependency:resolve-plugins

# copy all but Angular source in
#COPY src/main/java /build/src/main/java
#COPY src/main/resources /build/src/main/resources
#COPY src/test /build/src/test




#COPY --from=node-builder build/dist /build/src/main/resources/static

#RUN mvn package

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