FROM openjdk:17
ARG JAR_FILE=build/libs/desafio-back-cb-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} desafio-back-cb.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/desafio-back-cb.jar"]