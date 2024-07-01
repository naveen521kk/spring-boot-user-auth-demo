FROM eclipse-temurin:21-jdk-alpine AS build-stage

WORKDIR /tmp
COPY . /tmp

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build-stage /tmp/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
