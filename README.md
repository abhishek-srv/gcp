**Product Service API**
**This project provides RESTful APIs to manage products. It exposes the following endpoints:
**

POST /products/add - Add a new product.
PUT /products/{id} - Update an existing product by ID.
GET /products - Retrieve all products.
GET /products/{id} - Retrieve a product by ID.

**Prerequisites**
Before running the application, make sure the following dependencies are installed:
Java 21
Maven
MongoDB (running locally or remotely)

**Steps to Set Up and Run the Application**
1. Clone the Repository
Clone the repository to your local machine:

2. Install Dependencies
Use Maven to install the dependencies:
mvn clean install

3. Set Up MongoDB
brew tap mongodb/brew
brew install mongodb-community@5.0

4. Start MongoDB
Start MongoDB locally on your machine. By default, it runs on port 27017:
Make sure MongoDB is running by navigating to http://localhost:27017 in your browser.

5. Configuration
Ensure the application.properties file is correctly configured. Here's an example configuration to connect to MongoDB:

spring.data.mongodb.uri=mongodb://localhost:27017/productdb
server.port=8080
This configures the application to run on port 8080 and connect to a local MongoDB instance running on localhost:27017.

6. Run the Application
To run the application, use the following command:
This will start the Spring Boot application on port 8080. You can verify that it is running by accessing http://localhost:8080.

7. Accessing the API Endpoints
Now, you can access the following API endpoints:

Add a Product (POST)
URL: http://localhost:8080/products/add
{
  "productId": "a4f8b6f2-6345-48a4-b4c7-4e81fcdc6e6d",
  "name": "Product Name",
  "description": "Product Description",
  "category": "Electronics",
  "price": 100.0,
  "availableStock": 50,
}

Update a Product (PUT)
URL: http://localhost:8080/products/{id}

Method: PUT

Request Body:

json
Copy
Edit
{
  "name": "Updated Product Name",
  "description": "Updated Product Description",
  "price": 120.0
}
Get All Products (GET)
URL: http://localhost:8080/products

Method: GET

Response: Returns a list of all products.

Get a Product by ID (GET)
URL: http://localhost:8080/products/{id}

Method: GET

Response: Returns the product with the specified ID.

8. Handle Errors
The API will return appropriate error responses in case of failures:

400 Bad Request: If there are validation errors or bad input.

404 Not Found: If the product with the specified ID is not found.

9. Stop the Application

