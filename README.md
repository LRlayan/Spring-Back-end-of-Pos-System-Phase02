### API Overview
- **This API is designed to be easy to integrate with front-end applications, mobile apps, or other third-party services to facilitate grocery store operations in a reliable and scalable manner. This project is a RESTful API for a POS system. For detailed API usage, please refer to the API Documentation.
  
## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [API Documentation](#api-documentation)

---

### Key Features:
- **Item Management**: Create, update, retrieve, and delete items in the store's inventory.
- **Customer Management**: Perform CRUD operations for customer profiles.
- **Order Management**: Place and manage customer orders, including handling discounts, subtotals, and balances.
- **Transactions**: Supports complex transactional operations, ensuring data integrity when placing and managing orders.

### Technologies Used:
- **Backend Framework**: Spring Boot with Jakarta EE integration.
- **Database**: MySQL for persistent data storage.
- **Versioning**: v1 (future updates may introduce new versions).
- **Build Tool**: Maven
- **Containerization**: Tomcat 11 (optional)
- **Java Version**: 21

---

### API Documentation

## 1. **Items API**

### 1.1 Create a New Item
**Endpoint**: `POST /items`

- **Description**: Creates a new item in the system.
- **Request Body** (JSON):
    ```json
    {
      "itemCode": "I001",
      "name": "Product A",
      "quantity": 10,
      "price": 100.0 
    }
   
- **Response(201 Created)
    ```json
    {
      "message": "Item created successfully",
      "item": {
        "itemCode": "I001",
        "name": "Product A",
        "quantity": 10,
        "price": 100.0
      }
    }

### 1.2 Update an Item
**Endpoint**: `PUT api/v1/items/{itemCode}`

- **Description**: Updates the details of an existing item.
- **Request Body** (JSON):
    ```json
    {
      "name": "Product B",
      "price": 110.0,
      "quantity": 12
    }

- **Response(204 No Content)
    ```json
    {
      "message": "Item updated successfully",
      "item": {
        "itemCode": "I001",
        "name": "Product B",
        "quantity": 12,
        "price": 110.0
      }
    }

### 1.3 Delete an Item
**Endpoint**: `DELETE api/v1/items/{itemCode}`

- **Description**: Deletes a specific item from the inventory.
- **Response(204 No Content)
    ```json
    {
      "message": "Item deleted successfully"
    }

### 1.4 Get a Specific Item
**Endpoint**: `GET api/v1/items/{itemCode}`

- **Description**: Retrieves details of a specific item by its item code.
- **Response (200 OK):
    ```json
    {
      "itemCode": "I001",
      "name": "Product A",
      "quantity": 10,
      "price": 100.0
    }

### 1.5 Get All Items
**Endpoint**: `GET api/v1/items`

- **Description**: Retrieves all available items in the inventory.
- **Response (200 OK):
    ```json
    [
      {
        "itemCode": "I001",
        "name": "Product A",
        "quantity": 10,
        "price": 100.0
      },
      {
        "itemCode": "I002",
        "name": "Product B",
        "quantity": 5,
        "price": 150.0
      }
    ]

