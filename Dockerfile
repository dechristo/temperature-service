FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
COPY build/libs/temperature-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]