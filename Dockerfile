### STAGE 1: Build ###

FROM maven:3-openjdk-11 as dependencies
WORKDIR /app
ADD . .
RUN mvn clean package

### STAGE 2: Run ###

FROM openjdk:11
WORKDIR /app
COPY --from=dependencies /app/target/poke-api.jar poke-api.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar poke-api.jar
