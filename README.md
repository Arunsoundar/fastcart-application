# 🛒 FastCart - Inventory Management System

My first Spring Boot project to manage Products, Vendors, and Employees with integrated role-based security using Spring Security and MySQL.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- MySQL (Dockerized)
- Postman (for API testing)
- Lombok
- Maven

---

##Authentication & Authorization

### User Roles:
- `ADMIN` – Can perform CRUD on all endpoints.
- `USER` – Can **only view products** (`GET`).

###Sample Users (Already in MySQL DB):

| Username | Password | Role  |
|----------|----------|-------|
| admin    | admin    | ADMIN |
| user     | user     | USER  |

🧂 Passwords are encrypted using **BCrypt**.

---

## Modules & Endpoints

###Product APIs

| Method | Endpoint           | Access   |
|--------|--------------------|----------|
| GET    | `/product`         | USER/ADMIN |
| POST   | `/product`         | ADMIN   |
| PUT    | `/product/{id}`    | ADMIN   |
| DELETE | `/product/{id}`    | ADMIN   |

###Vendor APIs

| Method | Endpoint          | Access   |
|--------|-------------------|----------|
| GET    | `/vendor`         | ADMIN   |
| POST   | `/vendor`         | ADMIN   |
| PUT    | `/vendor/{id}`    | ADMIN   |
| DELETE | `/vendor/{id}`    | ADMIN   |

### Employee APIs

| Method | Endpoint          | Access   |
|--------|-------------------|----------|
| GET    | `/employee`       | ADMIN   |
| POST   | `/employee`       | ADMIN   |

---

## MySQL Setup (via Docker)

```bash
docker run --name fastcart-mysql \
  -e MYSQL_ROOT_PASSWORD=admin123 \
  -e MYSQL_DATABASE=fastcart \
  -p 3306:3306 \
  -d mysql:8
