# 🧑‍💼 UserService Microservice

A hotel rating microservices application that manages users, ratings, and hotels. It is built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This service supports full CRUD operations for managing users.

---

## 🚀 Features

- Create new users
- Get all users
- Get a user by ID
- Update user details
- Delete a user
- RESTful API design
- MySQL database integration
- Spring Boot 3.x compatible

---

## 📆 Common Tech Stack

All services in this microservices ecosystem use the following base technologies:

- Java 21
- Spring Boot 3.4.x
- Spring Data JPA
- MySQL
- Maven
- Lombok (for boilerplate reduction)

> You can use different technologies for different microservices according to your requirements.
> You can also use multiple databases according to your choices.

---

## 📌 API Endpoints - UserService

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/users`      | Create a new user |
| GET    | `/users`      | Get all users     |
| GET    | `/users/{id}` | Get user by ID    |
| PUT    | `/users/{id}` | Update user by ID |
| DELETE | `/users/{id}` | Delete user by ID |

---

## 💾 MySQL Configuration (`application.properties`) - UserService

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/userservice
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.application.name=USER-SERVICE
server.port=8081
```

---

# 🏨 HotelService Microservice

This microservice is responsible for managing **Hotel** data. It operates alongside `UserService` and `RatingService` as part of the hotel rating application.

---

## 🚀 Features

- Create new hotels
- Get all hotels
- Get hotel by ID
- Update hotel details
- Delete a hotel
- RESTful API design
- Integrated with MySQL
- Spring Boot 3.x compatible

---

## 📌 API Endpoints - HotelService

| Method | Endpoint       | Description        |
| ------ | -------------- | ------------------ |
| POST   | `/hotels`      | Create a new hotel |
| GET    | `/hotels`      | Get all hotels     |
| GET    | `/hotels/{id}` | Get hotel by ID    |
| PUT    | `/hotels/{id}` | Update hotel by ID |
| DELETE | `/hotels/{id}` | Delete hotel by ID |

---

## 💾 MySQL Configuration (`application.properties`) - HotelService

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotelservice
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.application.name=HOTEL-SERVICE
server.port=8082
```

---

# ⭐ RatingService Microservice

A microservice for handling **User Ratings** of hotels. It allows users to rate hotels and stores their feedback. Interacts with both `UserService` and `HotelService`.

---

## 🚀 Features

- Create a new rating
- Get all ratings
- Get ratings by user
- Get ratings by hotel
- RESTful API design
- Spring Boot 3.x compatible

---

## 📌 API Endpoints - RatingService

| Method | Endpoint                    | Description             |
| ------ | --------------------------- | ----------------------- |
| POST   | `/ratings`                  | Create a new rating     |
| GET    | `/ratings`                  | Get all ratings         |
| GET    | `/ratings/users/{userId}`   | Get ratings by User ID  |
| GET    | `/ratings/hotels/{hotelId}` | Get ratings by Hotel ID |

---

## 💾 MySQL Configuration (`application.properties`) - RatingService

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ratingservice
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.application.name=RATING-SERVICE
server.port=8083
```

---

