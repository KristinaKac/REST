FROM openjdk:8-jdk-alpine

EXPOSE 8085

ADD target/demo1-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

