# Student-Course-Project-With-Spring-Boot

This is a full-stack Spring Boot web application for managing students and courses, allowing registration and listing via a PostgreSQL database. The application also includes a simple HTML-based interface and REST-like behavior using Thymeleaf and Postman testing.

---

## 🚀 Technologies Used

- **Java 17**
- **Spring Boot 3.4.4**
  - Spring Web
  - Spring Data JPA
  - Spring Boot DevTools
  - Thymeleaf
- **PostgreSQL**
- **Postman**
- **DBeaver**
- **Lombok**

---

## 🧱 Project Structure

```
com.egitim.ogrencikayit
│
├── model/
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── repository/
│   ├── StudentRepository.java
│   ├── CourseRepository.java
│   └── EnrollmentRepository.java
│
├── service/
│   └── StudentService.java
│
├── controller/
│   └── StudentController.java
│
├── resources/templates/
│   ├── form.html
│   ├── register-by-name.html
│   └── enrollments.html
│
└── application.properties
```

---

## 🗂️ Database Schema

**Database Name:** `ogrencikayit`

### Tables:
- `Student`: id, name
- `Course`: id, name
- `Enrollment`: id, student_id, course_id

> Relationship: Many-to-Many (with a join table `student_courses`)  
> Additionally, an `Enrollment` entity is used for explicit enrollment management.

---

## ⚙️ Configuration (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ogrencikayit
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

---

## 📮 API Endpoints (Form-based submission)

| Method | Endpoint                    | Description                       |
|--------|-----------------------------|-----------------------------------|
| POST   | `/students/register`        | Register by student & course ID  |
| POST   | `/students/register-by-name`| Register by student & course name|
| GET    | `/students/form`            | View form and list data          |
| GET    | `/students/enrollments`     | View all enrollments             |

---

## 🖼️ HTML Interface (Thymeleaf Templates)

- `form.html`: Basic form for ID-based registration
- `register-by-name.html`: Form for name-based registration
- `enrollments.html`: Table of all student-course pairs

---

## 📬 Sample Request (Postman)

**POST /students/register-by-name**

```x-www-form-urlencoded
studentName = Ayşe Yılmaz
courseName = Fizik 101
```

---

## ▶️ How to Run

1. Clone the project:
```bash
git clone https://github.com/yourusername/student-course-project.git
```

2. Open in Spring Tool Suite 4

3. Update `application.properties` with your PostgreSQL credentials

4. Run the project:
```bash
./mvnw spring-boot:run
```

5. Access via browser:
```
http://localhost:8080/students/form
```

---

## 👨‍💻 Author

**Baturhan Çağatay**  
Spring Boot enthusiast • PostgreSQL Explorer • Web Developer in Progress

---

## 📄 License

MIT License — feel free to use and modify ✨
