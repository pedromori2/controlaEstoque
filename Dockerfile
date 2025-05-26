# Etapa 1: Build da aplicação
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia apenas o pom.xml para baixar as dependências (aproveita cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código e compila
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagem leve para rodar a aplicação
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o JAR gerado do estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Define o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
