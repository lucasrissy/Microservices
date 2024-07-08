FROM openjdk:17-jdk-slim

LABEL authors="lucasrissi"

# Set the working directory
WORKDIR /app

COPY target/Loans-0.0.1-SNAPSHOT.jar /app/Loans-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8090

ENTRYPOINT ["java", "-jar","Loans-0.0.1-SNAPSHOT.jar"]