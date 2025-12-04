# Etapa 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS build   # imagem com JDK 21

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM eclipse-temurin:21-jdk-alpine   # runtime também em 21

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

