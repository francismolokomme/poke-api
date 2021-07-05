FROM openjdk:11
VOLUME ["/data"]
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/poke-api.jar
WORKDIR /usr/src
ENTRYPOINT ["java", "-jar", "poke-api.jar"]