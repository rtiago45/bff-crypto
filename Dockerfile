FROM ubuntu:latest
LABEL authors="Tiagoo"

ENTRYPOINT ["top", "-b"]

# ====== build (Maven) ======
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package

# ====== runtime (JRE) ======
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o jar gerado
COPY --from=build /src/target/*.jar /app/app.jar

# Baixa o Datadog Java Agent
ADD https://repo1.maven.org/maven2/com/datadoghq/dd-java-agent/1.52.1/dd-java-agent-1.52.1.jar /opt/dd/dd-java-agent.jar

# Ativa o javaagent
ENV JAVA_TOOL_OPTIONS="-javaagent:/opt/dd/dd-java-agent.jar"

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
