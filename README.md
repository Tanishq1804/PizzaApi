# Pizza Shop CRUD REST API

## Overview
A RESTful API for a local pizza shop to manage pizzas and orders, built with *Spring Boot* and *MongoDB. Optional **Spring WebFlux* for reactive, non-blocking operations.

## Features

### Data Models
- *Pizza*: name, description, toppings, size, price.
- *Order*: order ID, list of pizzas, status, timestamp.

### CRUD Endpoints

#### Pizzas
- *POST* /api/pizzas: Add a new pizza.
- *GET* /api/pizzas: Get all pizzas.
- *GET* /api/pizzas/{id}: Get pizza by ID.
- *PUT* /api/pizzas/{id}: Update pizza.
- *DELETE* /api/pizzas/{id}: Remove pizza.

#### Orders
- *POST* /api/orders: Place a new order.
- *GET* /api/orders: Get all orders.
- *GET* /api/orders/{id}: Get order by ID.
- *PUT* /api/orders/{id}: Update order status.

## Installation

1. *Clone the repo*:
   ```bash
   git clone https://github.com/yourusername/pizza-api.git
   cd pizza-api
