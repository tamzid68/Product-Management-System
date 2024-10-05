Product Management System
This is a Spring Boot application that serves as a simple Product Management System. The system allows users to perform CRUD (Create, Read, Update, Delete) operations on products. The system features a web interface as well as an API that can be used to manage products.

Features
Product Management: Create, read, update, and delete products.
Image Upload: Upload and manage product images.
Validation: Validates product details (name, brand, price, etc.) before saving.
API Endpoints: REST API to interact with the system programmatically.
Technologies Used
Java
Spring Boot
Spring Data JPA
Thymeleaf (for HTML templates)
Hibernate (for ORM)
Jakarta Validation (for validating input)
MySQL (Database)
Table of Contents
Installation
Database Setup
Running the Application
API Endpoints
Web Interface
Installation
To get started with the project, follow these steps:

Clone the repository:

bash
Copy code
git clone https://github.com/your-username/product-management-system.git
cd product-management-system
Configure the database: Update the application.properties file to point to your MySQL database.

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/my_database?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Install dependencies: Make sure you have Maven installed. Run the following command to install all dependencies:

bash
Copy code
mvn clean install
Database Setup
The application uses MySQL as the database.

Create a database in MySQL:

sql
Copy code
CREATE DATABASE my_database;
Update the application.properties file as shown above.

Running the Application
You can run the application using the following command:

bash
Copy code
mvn spring-boot:run
The application will start at http://localhost:8080.

API Endpoints
This application provides the following REST API endpoints:

Add a product:

bash
Copy code
POST /api/add_product
Request Body: JSON object containing product details.
Response: Newly created product details.
Get all products:

bash
Copy code
GET /api/get_product
Response: List of all products.
Update a product by ID:

bash
Copy code
PUT /api/update/{id}
Request Body: JSON object containing updated product details.
Response: Updated product details.
Delete a product by ID:

bash
Copy code
DELETE /api/delete/{id}
Response: HTTP status indicating whether the deletion was successful.
Web Interface
The application also comes with a simple web interface, accessible at:

Home Page: http://localhost:8080/products

This page lists all available products.

Create Product Page: http://localhost:8080/products/create

Allows the user to create a new product.

Edit Product Page: http://localhost:8080/products/edit

Allows the user to update product details.

Delete Product Action:

Deletes a product based on its ID from the product list page.

Folder Structure
src/main/java/com/store - Main project package
src/main/java/com/store/model - Contains the ProductModel and ProductDtoModel classes, representing the product entity and its data transfer object.
src/main/java/com/store/service - Service classes that contain business logic.
src/main/java/com/store/repository - JPA repository interface for interacting with the database.
src/main/java/com/store/controller - Controllers for handling HTTP requests and API endpoints.
Future Enhancements
Search and Filter: Add search and filter functionality to the product listing page.
User Authentication: Secure the API and web pages with authentication and authorization.
Pagination: Add pagination to the product listing for better scalability.
License
This project is licensed under the MIT License. See the LICENSE file for more details.
