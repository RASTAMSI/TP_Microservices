FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
