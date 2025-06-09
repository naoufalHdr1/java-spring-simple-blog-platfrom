# Simple Blog Platform (Java + Spring Boot)

## 📖 Overview

A simple and functional Blog Platform built with **Spring Boot**, **Thymeleaf**, and **PostgreSQL**.  
This project allows users to register, log in, create and manage blog posts, and interact with other users through comments.

## 🚀 Features

- 🧑‍💻 User registration and login
- 📝 Create, edit, and delete blog posts
- 💬 Comment on blog posts
- 🔐 Secure access with Spring Security
- 📄 Thymeleaf-powered server-side HTML rendering
- 🗃️ PostgreSQL database integration
- 📂 RESTful architecture and clean code organization

## 📦 Tech Stack

```
+-----------------+------------------------------+
| Layer           | Technology                   |
|-----------------+------------------------------|
| Backend         | Spring Boot, Spring MVC      |
| Template Engine | Thymeleaf                    |
| Security        | Spring Security              |
| Database        | PostgreSQL + Spring Data JPA |
| Build Tool      | Maven                        |
| Language        | Java 21+                     |
+-----------------+------------------------------+
```

## 🗂️ Project Structure

```
src/
└── main/
├── java/
│ └── com.example.blog/
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── entity/
│ ├── dto/
│ └── config/
└── resources/
├── templates/ # Thymeleaf HTML templates
├── static/ # CSS, JS, images
└── application.properties
```

## ⚙️ Getting Started

### Prerequisites

- Java 21+
- Maven
- PostgreSQL

### Steps

1. **Clone the Repository**

```bash
git clone https://github.com/your-username/spring-boot-blog-platform.git
cd spring-boot-blog-platform
```

2. **Configure PostgreSQL**

Create a new database and update your application.properties:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Run the Application**

```bash
./mvnw spring-boot:run
```

4. Access the App

Open `http://localhost:8080` in your browser.

## 🛡️ Security

- User roles and authentication handled with Spring Security.
- Public access to blog viewing, login, and registration.
- Authenticated users can create/edit/delete their own posts.

## 🧱 Future Improvements

- Tagging system for posts
- Profile page for each user
- Like system for posts and comments
- Admin panel for content moderation
- REST API support (for future frontend integration)

## 📄 License

Feel free to use it for learning or adapt it to your needs!
