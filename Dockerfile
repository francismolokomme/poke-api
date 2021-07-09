
FROM openjdk:11
VOLUME ["/data"]
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/poke-api.jar
WORKDIR /usr/src
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "poke-api.jar"]