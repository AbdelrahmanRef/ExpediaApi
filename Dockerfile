FROM eclipse-temurin:17-jdk-alpine
LABEL authors="abdre"
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
RUN cp target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
