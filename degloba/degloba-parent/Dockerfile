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

RUN mvn package

RUN mvn install