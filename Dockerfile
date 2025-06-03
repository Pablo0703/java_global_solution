# Etapa de build usando Maven com JDK 21 já instalado
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos necessários
COPY pom.xml .
COPY src ./src

# Compila o projeto ignorando testes
RUN mvn clean package -DskipTests

# Etapa de execução com imagem leve
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia o JAR gerado para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Exponha a porta da aplicação
EXPOSE 8081

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
