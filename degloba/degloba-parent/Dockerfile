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


COPY settings.xml /usr/share/maven/ref/repository/
COPY pom.xml /build/pom.xml

RUN mvn install


# copy all but Angular source in
COPY ./degloba-domain/src/main/java /build/degloba-domain/src/main/java
COPY ./degloba-domain/src/main/resources /build/degloba-domain/src/main/resources
COPY ./degloba-domain/src/test /build/degloba-domain/src/test
COPY ./degloba-domain/pom.xml /build/degloba-domain/


COPY ./degloba-ioc-spring/src/main/java /build/degloba-ioc-spring/src/main/java
COPY ./degloba-ioc-spring/src/main/resources /build/degloba-ioc-spring/src/main/resources
COPY ./degloba-ioc-spring/src/test /build/degloba-ioc-spring/src/test
COPY ./degloba-ioc-spring/pom.xml /build/degloba-ioc-spring/


COPY ./degloba-persistence/pom.xml /build/degloba-persistence/

COPY ./degloba-integration/src/main/java /build/degloba-integration/src/main/java
#COPY ./degloba-integration/src/main/resources /build/degloba-integration/src/main/resources
COPY ./degloba-integration/src/test /build/degloba-integration/src/test
COPY ./degloba-integration/pom.xml /build/degloba-integration/

COPY ./degloba-utilitats/src/main/java /build/degloba-utilitats/src/main/java
COPY ./degloba-utilitats/src/main/resources /build/degloba-utilitats/src/main/resources
#COPY ./degloba-utilitats/src/test /build/degloba-utilitats/src/test
COPY ./degloba-utilitats/pom.xml /build/degloba-utilitats/

COPY ./degloba-cqrs/src/main/java /build/degloba-cqrs/src/main/java
#COPY ./degloba-cqrs/src/main/resources /build/degloba-cqrs/src/main/resources
#COPY ./degloba-cqrs/src/test /build/degloba-cqrs/src/test
COPY ./degloba-cqrs/pom.xml /build/degloba-cqrs/

COPY ./degloba-infrastructure/src/main/java /build/degloba-infrastructure/src/main/java
#COPY ./degloba-infrastructure/src/main/resources /build/degloba-infrastructure/src/main/resources
#COPY ./degloba-infrastructure/src/test /build/degloba-infrastructure/src/test
COPY ./degloba-infrastructure/pom.xml /build/degloba-infrastructure/

#COPY ./degloba-ioc-test/src/main/java /build/degloba-ioc-test/src/main/java
#COPY ./degloba-ioc-test/src/main/resources /build/degloba-ioc-test/src/main/resources
#COPY ./degloba-ioc-test/src/test /build/degloba-ioc-test/src/test
COPY ./degloba-ioc-test/pom.xml /build/degloba-ioc-test/

COPY ./degloba-event-api/src/main/java /build/degloba-event-api/src/main/java
#COPY ./degloba-event-api/src/main/resources /build/degloba-event-api/src/main/resources
#COPY ./degloba-event-api/src/test /build/degloba-event-api/src/test
COPY ./degloba-event-api/pom.xml /build/degloba-event-api/

COPY ./degloba-facade/src/main/java /build/degloba-facade/src/main/java
COPY ./degloba-facade/src/main/resources /build/degloba-facade/src/main/resources
COPY ./degloba-facade/src/test /build/degloba-facade/src/test
COPY ./degloba-facade/pom.xml /build/degloba-facade/

COPY ./degloba-webapp/src/main/java /build/degloba-webapp/src/main/java
COPY ./degloba-webapp/src/main/resources /build/degloba-webapp/src/main/resources
COPY ./degloba-webapp/src/test /build/degloba-webapp/src/test
COPY ./degloba-webapp/pom.xml /build/degloba-webapp/

COPY ./degloba-security/src/main/java /build/degloba-security/src/main/java
#COPY ./degloba-security/src/main/resources /build/degloba-security/src/main/resources
COPY ./degloba-security/src/test /build/degloba-security/src/test
COPY ./degloba-security/pom.xml /build/degloba-security/

WORKDIR /build/degloba-utilitats
RUN mvn install

WORKDIR /build/degloba-event-api
RUN mvn install

WORKDIR /build/degloba-domain
RUN mvn install

#RUN mvn -B -f /build/pom.xml -s /usr/share/maven/ref/repository/settings.xml dependency:resolve

#RUN mvn -B -f /build/degloba-domain/pom.xml -s /usr/share/maven/ref/repository/settings.xml dependency:resolve

#RUN mvn install


#RUN mvn -B dependency:resolve dependency:resolve-plugins




#COPY --from=node-builder build/dist /build/src/main/resources/static

RUN mvn package