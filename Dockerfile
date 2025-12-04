# Etapa 1: Construção (Build)
# Etapa 1: Build
FROM maven:3.8.5-openjdk-17 AS build

# Define uma pasta de trabalho
WORKDIR /app

# Copia só o necessário para o build (aproveita cache melhor)
COPY pom.xml .
COPY src ./src

# Roda o Maven dentro da pasta /app
RUN mvn clean package -DskipTests

# Etapa 2: Execução (Run)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Repare no caminho: /app/target/
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
