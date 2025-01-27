# Use the Java 23 base image (Oracle JDK)
FROM openjdk:23-oracle

# Create a volume to store temporary files
VOLUME /tmp

# Expose the port your application runs on
EXPOSE 8080

# Add your application JAR file to the container
ADD ./build/libs/rentalService-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run the JAR file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
