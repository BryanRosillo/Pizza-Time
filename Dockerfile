FROM eclipse-temurin:17-jdk-alpine
LABEL authors="Bryan"
WORKDIR /app
COPY target/pizza-time-0.0.1-SNAPSHOT.jar pizza-time.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/pizza-time.jar"]
