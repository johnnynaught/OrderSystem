# Use a lightweight base image with Java runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file (make sure to replace with your actual JAR file name)
COPY target/OrderSystemBackEnd-0.0.1-SNAPSHOT.jar OrderSystemBackEnd-0.0.1-SNAPSHOT.jar

# Expose the application port (change if necessary)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "OrderSystemBackEnd-0.0.1-SNAPSHOT.jar"]