FROM openjdk:17
ADD target/mts.jar /app/mts.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "mts.jar"]