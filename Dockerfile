# build用
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# まず全部コピー
COPY . .

# ビルド
RUN mvn clean package -DskipTests

# 実行用
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]