# ---------- build stage ----------
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./mvnw -q -DskipTests package

# ---------- runtime stage ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/estoque-service-*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app/app.jar"]
