# Product Management System

## Project Overview
The **Product Management System** is a Spring Boot application designed for managing product data with basic CRUD (Create, Read, Update, Delete) functionalities. It utilizes a microservices architecture and follows SOLID design principles, allowing for modularity and scalability. The application can also be run as a web application, providing an interactive user interface.

## Key Components

- **Architecture**:
  - **Microservices**: The application is structured into independent services, each responsible for specific functionalities, enhancing scalability and maintainability.
  - **SOLID Principles**: The design follows SOLID principles, ensuring high cohesion and low coupling between components, making the system easier to manage and extend.

- **Model**: Represents the data structure of the application.
  - **Product**: A class representing a product with attributes such as `id`, `name`, `description`, and `price`.

- **Controller**: Manages the incoming HTTP requests and responses.
  - **ApiProductController**: A REST controller that provides endpoints for product operations.
  - **ProductController**: A controller that handles web requests related to product management.

- **Service**: Contains business logic.
  - A `ProductService` typically manages operations related to products.

- **Repository**: Interfaces with the database to perform CRUD operations.

## Functionality

- **Create Product**:
  - **Endpoint**: `POST /api/products`
  - **Description**: Adds a new product to the database.
  - **Request Body**: JSON representation of the product (name, description, price).

- **Read Products**:
  - **Endpoint**: `GET /api/products`
  - **Description**: Retrieves a list of all products.
  - **Response**: JSON array of products.

- **Read Product by ID**:
  - **Endpoint**: `GET /api/products/{id}`
  - **Description**: Fetches details of a specific product by its ID.
  - **Response**: JSON representation of the product.

- **Update Product**:
  - **Endpoint**: `PUT /api/products/{id}`
  - **Description**: Updates the details of an existing product.
  - **Request Body**: JSON representation of the product with updated fields.

- **Delete Product**:
  - **Endpoint**: `DELETE /api/products/{id}`
  - **Description**: Deletes a product by its ID.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tamzid68/spingboot_product_CRUD-

Navigate to Project Directory:

bash

cd spingboot_product_CRUD-
Build the Project:

bash

mvn clean install
Run the Application:

bash

mvn spring-boot:run
Access the Application: Open a web browser and navigate to http://localhost:8080/api/products.


Deployment
The application is deployed online and can be accessed at the following link: https://humorous-expression-production.up.railway.app/

Postman Workspace and API Documentation
Postman Workspace: Access your collection in the public workspace at https://www.postman.com/asmtamzid/my-workspace/overview.

Published API Documentation: View the API documentation at https://documenter.getpostman.com/view/37703361/2sAXxMgtwJ.

Future Enhancements
Implement error handling and validation.
Add user authentication and authorization.
Introduce unit and integration tests.
Enhance the UI with a frontend framework like React or Angular.
