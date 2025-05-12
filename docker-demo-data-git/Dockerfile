# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY target/app.jar app.jar

# Expose the application's running port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]