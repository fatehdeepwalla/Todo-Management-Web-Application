
# 📝 Todo Management Web Application

A secure full stack Todo management web application built with Spring Boot, Spring MVC, JSP, Spring Security, Spring Data JPA, H2.

The application features user authentication, Todo CRUD operations, form validation, and database persistence.

---

## 🛠️ Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Backend Framework** | Java, Spring Boot, Spring MVC |
| **Security** | Spring Security (Form Authentication, BCrypt Password Encoding) |
| **Persistence Layer** | Spring Data JPA, Hibernate |
| **Database** | H2 In-Memory Database |
| **Frontend Templates** | JSP (JavaServer Pages), JSTL |
| **UI & Styling** | Bootstrap 5, jQuery, Bootstrap Datepicker |
| **Validation** | Hibernate Validator |
| **Build Tooling** | Apache Maven |

---

## ✨ Key Features

* **🔒 Authentication**: Secure authentication powered by Spring Security using standard form logins and BCrypt password encryption.
* **⚡ Full Task Lifecycle (CRUD)**: Create, view, update, and delete personal todo items bound to individual logged-in user sessions.
* **🛡️ Data Validation**: Server-side field validation to ensure valid description lengths and completion dates before saving.
* **🎨 Responsive UI**: Built with Bootstrap 5 templates and interactive datepickers for accurate target date management.
* **💾 JPA Persistence**: Automatic table schema generation and entity mapping via Spring Data JPA backed by H2.
* **🌱 Automated Seeding**: Pre-loaded startup data populated automatically using custom SQL scripts.

---

## 🚀 Quick Start Guide

- **Prerequisites**
   * JDK 17 or higher
   * Maven 3.8+

- **Run Locally**

   - Clone Repository
      ```bash
      git clone https://github.com/fatehdeepwalla/Todo-Management-Web-Application.git
      cd Todo-Management-Web-Application
      ```
   
   - Launch Application
      ```bash
      ./mvnw spring-boot:run
      ```
---


## 🔗 Accessing the Application

- 🌐 Web Dashboard: `http://localhost:8080`
- 🗄️ H2 Database Console: `http://localhost:8080/h2-console`
- ⚙️ Console Credentials & Settings:
  
   | Setting | Value |
   | :--- | :--- |
   | **JDBC URL** | `jdbc:h2:mem:testdb` |
   | **Username** | `sa` |
   | **Password** | *(Leave empty)* |

