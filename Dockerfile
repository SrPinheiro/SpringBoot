FROM openjdk:17-oracle

WORKDIR /app

COPY target/course-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]

