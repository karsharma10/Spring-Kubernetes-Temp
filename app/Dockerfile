# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the entire project directory into the container
COPY . .

# Build the project (assuming you are using Maven)
RUN ./mvnw clean package

# Start a new stage to create the final image
FROM openjdk:17-slim

# Set the working directory to /app in the container
WORKDIR /app

# Copy only the built JAR from the build stage
COPY --from=build /app/target/*.jar ./app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "app.jar"]
