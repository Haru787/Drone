# 1. ビルド用の環境
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# 先にpom.xmlだけコピーして依存ライブラリをダウンロード（キャッシュ利用）
COPY pom.xml .
RUN mvn dependency:go-offline -B

# その後にソースコードをコピーしてビルド
COPY src ./src
RUN mvn clean package -DskipTests

# 2. 実行用の環境
FROM eclipse-temurin:17-jre
WORKDIR /app
# ビルドステージからjarをコピー（ワイルドカードより具体的な名前が安全です）
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]