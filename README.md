# UserService Microservice

A simple **User Management Microservice** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This service supports full CRUD operations for managing users.

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

## 📦 Tech Stack

- Java 21
- Spring Boot 3.4.x
- Spring Data JPA
- MySQL
- Maven
- Lombok (for boilerplate reduction)

---

## 📁 Project Structure


---

## 📌 API Endpoints

| Method | Endpoint        | Description              |
|--------|------------------|--------------------------|
| POST   | `/users`         | Create a new user        |
| GET    | `/users`         | Get all users            |
| GET    | `/users/{id}`    | Get user by ID           |
| PUT    | `/users/{id}`    | Update user by ID        |
| DELETE | `/users/{id}`    | Delete user by ID        |

---

## 💾 MySQL Configuration (in `application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/userservice
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
