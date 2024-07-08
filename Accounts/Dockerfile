FROM openjdk:17-jdk-slim

LABEL authors="lucasrissi"

# Set the working directory
WORKDIR /app

COPY target/Accounts-0.0.1-SNAPSHOT.jar /app/Accounts-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

ENTRYPOINT ["java","-jar","Accounts-0.0.1-SNAPSHOT.jar"]
