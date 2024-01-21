# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY ./build/libs/FizzBuzzServer-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Define environment variable
ENV JAVA_OPTS=""

# Run the JAR file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]