# 📇 Contacts API

A simple contact management system built with Java and Spring Boot.

---

# 🧩 Features
- Create, view, update, and delete contacts
- RESTful API with JSON responses
- In-memory and database storage support
- Complete API doc#umentation using Swagger

---

## 🛠 Technologies
- Java 17
- Spring Boot 3.3.3
- H2 (in-memory database)
- Lombok
- Swagger/OpenAPI

---

## ⚙️ Getting Started

### Prerequisites
- Java 17 installed
- Maven installed

### Clone the Repository
```bash
git clone https://github.com/hadiseShaaban/contacts.git
cd contacts
```

### Run with H2 (default)
```bash
mvn spring-boot:run
```

### Run with PostgreSQL (optional)
In the `application.properties` file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/contacts_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## 🔍 API Documentation
After starting the application, visit:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧪 Running Tests
```bash
mvn test
```

---

## 🤝 Contributing
Interested in contributing?
1. Fork the repository
2. Create a new branch
3. Make your changes and push
4. Submit a Pull Request

---

## 🪪 License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
