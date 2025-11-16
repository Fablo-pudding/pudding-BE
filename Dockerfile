FROM openjdk:21-ea-17-jdk
COPY build/libs/pudding-BE-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]