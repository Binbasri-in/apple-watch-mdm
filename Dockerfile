# Start with a base image containing Java runtime
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file (ensure the JAR file is built before running this Dockerfile)
# Assuming the JAR file is in the target directory after a Maven/Gradle build
COPY target/apple-mdm-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application will run on (update this based on your Spring Boot server port if not default)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]