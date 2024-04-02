FROM openjdk:17
ARG JAR_FILE=build/libs/desafio-back-cb-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} desafio-back-cb.jar
EXPOSE 8080

ENV SPRINGPROFILES=prod

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${SPRINGPROFILES}","-jar", "-Dserver.port=8080", "-Dserver.address=0.0.0.0", "/desafio-back-cb.jar"]