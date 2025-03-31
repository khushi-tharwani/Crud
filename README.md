# Load & Booking Management System

## 🚀 Overview
A Spring Boot backend with PostgreSQL (JDBC) for managing *Load & Booking operations*.

## 🛠 Setup Instructions
1. Install *Java 17, PostgreSQL, Maven, Postman*.
2. Create a PostgreSQL database:
   sql
   CREATE DATABASE load_booking_db;
   
3. Configure src/main/resources/application.properties:
   properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/load_booking_db
   spring.datasource.username=your_db_user
   spring.datasource.password=your_db_password
   
4. Build and run the project:
   sh
   mvn clean install
   mvn spring-boot:run
   

## 📜 API Endpoints
### *Load Management*
- *POST /load* → Create a new load
- *GET /load* → Fetch loads (filters: shipperId, truckType)
- *GET /load/{loadId}* → Get load details
- *PUT /load/{loadId}* → Update load
- *DELETE /load/{loadId}* → Delete load

### *Booking Management*
- *POST /booking* → Create a new booking
- *GET /booking* → Fetch bookings (filters: shipperId, transporterId)
- *GET /booking/{bookingId}* → Get booking details
- *PUT /booking/{bookingId}* → Update booking
- *DELETE /booking/{bookingId}* → Delete booking

