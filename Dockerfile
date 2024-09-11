# Sử dụng image chính thức của OpenJDK làm base image
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép file jar vào thư mục làm việc
COPY build/libs/FashionShop-0.0.1-SNAPSHOT.jar app.jar

# Cấu hình lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]

# Cổng mà ứng dụng Spring Boot sẽ lắng nghe
EXPOSE 8080
