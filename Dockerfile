# Use official Gradle image as build stage
FROM gradle:8.6-jdk17-alpine AS builder

# Set working directory
WORKDIR /app

# Clone the Git repository (you can also use COPY if code is in context)
# Note: For private repos, you'll need to handle SSH keys or tokens
ARG CACHE_BUSTER=1
RUN apk add --no-cache git && \
    git clone https://github.com/dheerajnetwcloud/services.git . && \
    git checkout master

# Build the application
RUN gradle build --no-daemon

# Use slim JRE image for runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Set environment variables if needed
# ENV SPRING_PROFILES_ACTIVE=production

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]