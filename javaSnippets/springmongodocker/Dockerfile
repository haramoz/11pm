FROM openjdk:17-jdk-alpine
WORKDIR /app

#ENV SPRING_DATA_MONGODB_URI="mongodb://admin:admin@mymongodb:27017/mydb?authSource=admin"

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080