# Use a base image
FROM openjdk:17-jdk-slim

LABEL authors="lucasrissi"

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY target/Cards-0.0.1-SNAPSHOT.jar /app/Cards-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 9090

# Command to run the application
CMD ["java", "-jar", "Cards-0.0.1-SNAPSHOT.jar"]
