FROM eclipse-temurin:21-jdk-alpine

WORKDIR /tmp
COPY . /tmp

RUN ./mvnw clean package -DskipTests

COPY target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
