# Use Maven to build the JAR
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use Java to run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/snappymob-challenge-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

VOLUME ["/input", "/output"]

CMD ["sh", "-c", "java -jar app.jar /input/data.txt /output/result.txt"]