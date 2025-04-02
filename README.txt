# 🛒 Spring Boot E-commerce Backend Project

This project is a **Spring Boot-based backend** for a simple e-commerce system. It supports product management, secure authentication, role-based access, and deployment to Apache Tomcat using a `.war` file.

> ✅ Built with Java 17, Spring Boot 3, Spring Security, Spring Data JPA, and H2 Database.

---

## 📌 Features

- ✅ REST API for Products (CRUD operations)
- 🔐 Spring Security with Basic Auth
- 👤 User roles: `ADMIN` and `USER`
- 🗄️ In-memory H2 database integration
- ⚙️ WAR packaging for deployment to Apache Tomcat
- 🧪 Test cases for security and validation

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- H2 Database
- Maven
- Apache Tomcat 10

---

## 📁 Project Structure

src/
├── controller/
├── model/
├── repository/
├── service/
├── config/
└── exception/



---

## 🚀 How to Run the Project Locally (with Embedded Tomcat)

### 1. Clone the repository

```bash
git clone https://github.com/asimshaikh161/EcomSpringBoot.git
cd EcomSpringBoot


2. Open in Spring Tool Suite or IntelliJ IDEA
3. Run the main application

Run DemoApplication.java

4. Test Endpoints using Postman
➤ Example Endpoint:

GET http://localhost:8080/products

➤ Login with Basic Auth:
Username: admin

Password: admin

🌍 Access H2 Console
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave blank)

🧑‍💼 Test Users (preloaded from import.sql)
Username	Password	Role
admin	         admin	        ADMIN
📦 How to Deploy as WAR on Apache Tomcat
1. Package the app

mvn clean install
➡️ Generates file: target/demo.war

2. Deploy WAR to Tomcat
Copy demo.war to:

apache-tomcat/webapps/

-Start Tomcat:
startup.bat (Windows) or ./startup.sh (Linux/Mac)
3. Access the App

http://localhost:8080/demo/products