# Etapa 1: Construção (Build)
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Execução (Run)
# AQUI ESTAVA O ERRO, TROCAMOS PARA UMA VERSÃO QUE EXISTE:
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]