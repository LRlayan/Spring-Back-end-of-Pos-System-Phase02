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
**Endpoint**: `POST api/v1/items`

- **Description**: Creates a new item in the system.
- **Request Body** (JSON):
    ```json
    {
      "itemCode": "I00-001",
      "name": "Product A",
      "quantity": 10,
      "price": 100.0 
    }
   
- Response(201 Created)
    ```json
    {
      "message": "Item created successfully",
      "item": {
        "itemCode": "I00-001",
        "name": "Product A",
        "quantity": 10,
        "price": 100.0
      }
    }

### 1.2 Update an Item
**Endpoint**: `PUT api/v1/items/{itemCode}`

- **Description**: Updates the details of an existing item.
- Request Body** (JSON):
    ```json
    {
      "name": "Product B",
      "price": 110.0,
      "quantity": 12
    }

- Response(204 No Content)
    ```json
    {
      "message": "Item updated successfully",
      "item": {
        "itemCode": "I00-001",
        "name": "Product B",
        "quantity": 12,
        "price": 110.0
      }
    }

### 1.3 Delete an Item
**Endpoint**: `DELETE api/v1/items/{itemCode}`

- **Description**: Deletes a specific item from the inventory.
- Response(204 No Content)
    ```json
    {
      "message": "Item deleted successfully"
    }

### 1.4 Get a Specific Item
**Endpoint**: `GET api/v1/items/{itemCode}`

- **Description**: Retrieves details of a specific item by its item code.
- Response (200 OK):
    ```json
    {
      "itemCode": "I00-001",
      "name": "Product A",
      "quantity": 10,
      "price": 100.0
    }

### 1.5 Get All Items
**Endpoint**: `GET api/v1/items`

- **Description**: Retrieves all available items in the inventory.
- Response (200 OK):
    ```json
    [
      {
        "itemCode": "I00-001",
        "name": "Product A",
        "quantity": 10,
        "price": 100.0
      },
      {
        "itemCode": "I00-002",
        "name": "Product B",
        "quantity": 5,
        "price": 150.0
      }
    ]

## 2. **Customers API**

### 2.1 Create a New Customer
**Endpoint**: `POST api/v1/customers`

- **Description**: Creates a new customer.
- **Request Body** (JSON):
    ```json
    {
      "customerId": "C00-001",
      "name": "John Doe",
      "city": "Colombo",
      "tel": "0771234567" 
    }
   
- Response(201 Created)
    ```json
    {
      "message": "Customer created successfully",
      "customer": {
        "customerId": "C00-001",
        "name": "John Doe",
        "city": "Colombo",
        "tel": "0771234567"
      }
    }

### 2.2 Update a Customer
**Endpoint**: `PUT api/v1/customers/{customerId}`

- **Description**: Update a Customer.
- **Request Body** (JSON):
    ```json
    {
      "name": "John",
      "city": "Kaluthara",
      "tel": "0784562352" 
    }
   
- Response(204 No Content)
    ```json
    {
      "message": "Customer Updated successfully",
      "customer": {
        "customerId": "C00-001",
        "name": "John",
        "city": "Kaluthara",
        "tel": "0784562352"
      }
    }

### 2.3 Delete a Customer
**Endpoint**: `DELETE api/v1/customers/{customerId}`

- **Description**: Deletes a specific Customer from the customers.
- Response(204 No Content)
    ```json
    {
      "message": "Customer deleted successfully"
    }

### 2.4 Get a Specific Customers
**Endpoint**: `GET api/v1/customers/{customerId}`

- **Description**: Retrieves details of a specific Customer by it's customerId.
- Response (200 OK):
    ```json
    {
      "customerId": "C00-001",
      "name": "John Doe",
      "city": "Colombo",
      "tel": "0771234567"
    }

### 2.5 Get All Customers
**Endpoint**: `GET api/v1/customers`

- **Description**: Retrieves all available customers in the customerList.
- Response (200 OK):
    ```json
    [
      {
        "customerId": "C00-001",
        "name": "John Doe",
        "city": "Colombo",
        "tel": "0771234567"
      },
      {
        "customerId": "C00-002",
        "name": "John",
        "city": "Kaluthara",
        "tel": "0784562352"
      }
    ]

## 3. **Orders API**

### 3.1 Place an Order
**Endpoint**: `POST api/v1/orders`

- **Description**: Place a new order.
- **Request Body** (JSON):
    ```json
    {
      "orderId": "O-01",
      "date": "2024-10-14",
      "discountRate": "5",
      "discount": "30",
      "subTotal": 600.0,
      "balance": 570.0,
      "customer": [
        {
          "customerId": "C00-001",
          "name": "John Doe",
          "city": "Colombo",
          "tel": "0771234567"
        }
      ],
      "orderDetailsList": [
          "id":"ORDER_DETAIL-351582dsfds65sc46scs8s8",
          "date":"2024-10-14",
          "customerId":"C00-001",
          "customerName":"John Doe",
          "customerCity":"Colombo",
          "customerTel":"0771234567",
          "itemName":"Product A",
          "orderQTY":"6",
          "unitPrice":"100.0",
          "item": [
            {
              "itemCode": "I00-001",
              "name": "Product A",
              "quantity": 10,
              "price": 100.0
            }
          ],
          "order": [
              "orderId": "O-01"
          ]
      }
   
- Response(201 Created)
    ```json
    {
      "message": "Place Order created successfully",
      "order": {
        "orderId": "O-01",
        "date": "2024-10-14",
        "discountRate": "5",
        "discount": "30",
        "subTotal": 600.0,
        "balance": 570.0
      }
    }

### 3.2 Update a Order
**Endpoint**: `PUT api/v1/orders/{orderId}`

- **Description**: Update a Order.
- **Request Body** (JSON):
    ```json
    {
      "date": "2024-10-14",
      "discountRate": "2",
      "discount": "15",
      "subTotal": 600.0,
      "balance": 585.0
    }
   
- Response(204 No Content)
    ```json
    {
      "message": "Order Updated successfully",
      "order": {
        "orderId": "O-01",
        "date": "2024-10-14",
        "discountRate": "2",
        "discount": "15",
        "subTotal": 600.0,
        "balance": 585.0,
      }
    }

### 3.3 Delete a Order
**Endpoint**: `DELETE api/v1/orders/{orderId}`

- **Description**: Deletes a specific Order from the orders.
- Response(204 No Content)
    ```json
    {
      "message": "Order deleted successfully"
    }

### 3.4 Get a Specific Orders
**Endpoint**: `GET api/v1/orders/{orderId}`

- **Description**: Retrieves details of a specific Order by it's orderId.
- Response (200 OK):
    ```json
    {
      "orderId": "O-01",
      "date": "2024-10-14",
      "discountRate": "5",
      "discount": "30",
      "subTotal": 600.0,
      "balance": 570.0
    }

### 3.5 Get All Orders
**Endpoint**: `GET api/v1/orders`

- **Description**: Retrieves all available orders in the orderList.
- Response (200 OK):
    ```json
    [
      {
        "orderId": "O-01",
        "date": "2024-10-14",
        "discountRate": "5",
        "discount": "30",
        "subTotal": 600.0,
        "balance": 570.0
      },
      {
        "orderId": "O-02",
        "date": "2024-10-14",
        "discountRate": "5",
        "discount": "30",
        "subTotal": 1000.0,
        "balance": 970.0
      }
    ]

    
