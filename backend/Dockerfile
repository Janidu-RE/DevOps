FROM eclipse-temurin:21-jre
WORKDIR /app
RUN mvn clean package -DskipTests
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]