# Giai đoạn build
FROM gradle:8.4-jdk21 AS build
WORKDIR /app
COPY . /app
RUN chmod +x gradlew
RUN ./gradlew clean build -x test -x check

# Giai đoạn chạy app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
