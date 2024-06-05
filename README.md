# Order Service

## Overview

The `order-service` is a part of a larger microservices architecture. It is responsible for handling orders, including creating and managing order items. This service interacts with other microservices to ensure a seamless ordering process.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)


## Features

- Create new orders with multiple line items.
- Retrieve order details.
- Manage order statuses.

## Architecture

The `order-service` is designed to be part of a microservices ecosystem. It interacts with:

- **Inventory Service**: To check and update stock levels.
- **Payment Service**: To handle payment processing.
- **Notification Service**: To send notifications about order status.

## Technologies Used

- **Spring Boot**: Framework for building the service.
- **Spring Data JPA**: For database interaction.
- **MapStruct**: For object mapping.
- **Lombok**: To reduce boilerplate code.
- **MySQL**: Database.
- **Maven**: Build and dependency management.

## Getting Started

### Prerequisites

- Java 17
- Maven 3.8+
- MySQL

### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-repository/order-service.git
    cd order-service
    ```

2. **Configure the database**:

    Create a database named `order_service` in MySQL and update the database configuration in `application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/order_service
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build the project**:

    ```bash
    mvn clean install
    ```

### Running the Application

1. **Run the application**:

    ```bash
    mvn spring-boot:run
    ```

2. The application should now be running on `http://localhost:8080`.

## API Endpoints

### Create Order

- **URL**: `/orders`
- **Method**: `POST`
- **Request Body**:

    ```json
    {
      "orderLineItemsReq": [
        {
          "sku": "item-sku-1",
          "price": 19.99,
          "quantity": 2
        },
        {
          "sku": "item-sku-2",
          "price": 29.99,
          "quantity": 1
        }
      ]
    }
    ```

- **Response**: `201 Created`

### Get Order

- **URL**: `/orders/{orderId}`
- **Method**: `GET`
- **Response**: `200 OK`
- **Response Body**:

    ```json
    {
      "id": 1,
      "orderNumber": "a1b2c3d4",
      "orderLineItems": [
        {
          "sku": "item-sku-1",
          "price": 19.99,
          "quantity": 2
        },
        {
          "sku": "item-sku-2",
          "price": 29.99,
          "quantity": 1
        }
      ]
    }
    ```

## Contributing

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.


