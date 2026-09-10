# Todo Management Web Application
A full-stack Spring Boot web application designed for task management.

This application is built with **Spring Boot, Spring MVC, JSP, Spring Security, Spring Data JPA, and H2**.

The application supports user authentication, Todo CRUD operations, form validation, and database persistence using H2.

## **Tech Stack**

* **Backend**: Java, Spring Boot, Spring MVC, Spring Security, Spring Data JPA
* **Database**: H2 In-Memory Database
* **Frontend**: JSP (JavaServer Pages), JSTL, Bootstrap 5, jQuery, Bootstrap Datepicker
* **Validation**: Spring Boot Starter Validation (Hibernate Validator)
* **Build Tool**: Maven

---

## **Key Features**

* **Authentication & Authorization**: Integrated Spring Security with custom `SecurityFilterChain` allowing form-based authentication.
* **Todo CRUD Operations**: Full capability to list, add, update, and delete todo items tied to specific users.
* **Input Validation**: Server-side validation on task descriptions requiring a minimum length before saving.
* **Interactive UI**: Clean responsive layout using Bootstrap 5 along with integrated datepickers for target completion dates.
* **In-Memory JPA Persistence**: Dynamic entity-to-table mapping using Spring Data JPA (`TodoRepository`) connected to H2.
* **Data Initializer**: Automatic database seeding on startup using `data.sql`.

---

## **Pre-Configured Demo Credentials**

| Username | Password | Roles |
| :--- | :--- | :--- |
| `in28minutes` | `dummy` | USER, ADMIN |
| `ranga` | `dummydummy` | USER, ADMIN |

---

## **Configuration & Setup**

### **App Properties (`application.properties`)**
```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.mvc.format.date=yyyy-MM-dd

# H2 Database Setup
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true
```

---

## **How to Run**

1. **Clone the Repository**
   ```bash
   git clone <your-repository-url>
   cd myfirstwebapp
   ```

2. **Build and Run**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the Application**
   * **Web App**: `http://localhost:8080`
   * **H2 Database Console**: `http://localhost:8080/h2-console`
     * **JDBC URL**: `jdbc:h2:mem:testdb`
     * **User Name**: `sa`
     * **Password**: *(leave blank)*

