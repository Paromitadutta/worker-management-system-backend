FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Learner-0.0.1-SNAPSHOT.jar Learner.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","Learner.jar"]