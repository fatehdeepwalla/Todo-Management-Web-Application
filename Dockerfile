# -------------------------
# Stage 1: Build the WAR
# -------------------------
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy Maven configuration first
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy application source code
COPY . .

# Build the WAR
RUN mvn clean package -DskipTests

# -------------------------
# Stage 2: Run the WAR
# -------------------------
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy the WAR produced by the builder stage
COPY --from=builder /app/target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]