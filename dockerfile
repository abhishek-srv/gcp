# Use the official Maven image as the base image for building the project
FROM maven:3.8.4-openjdk-21 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file (pom.xml) to the working directory
COPY pom.xml .

# Copy the entire source code into the container
COPY src ./src

# Download the dependencies and build the project
RUN mvn clean install -DskipTests

# Use OpenJDK as the base image for the final image
FROM openjdk:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the WAR file from the builder stage to the final image
COPY --from=builder /app/target/java-0.0.1-SNAPSHOT.war .

# Expose port 8080 to the outside world
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "java-0.0.1-SNAPSHOT.war"]
