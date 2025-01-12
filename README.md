# Order System Backend

A simple backend application that demonstrates managing **Products**, **Users**, **Orders**, and **Shopping Carts** using Spring Boot, JPA, and RESTful APIs.

## Overview

1. **Product Management**
   - Create, read, update, and delete (CRUD) operations for product information.
   - Each product has an `id`, `name`, and `price`.

2. **User Management**
   - Store and manage user data such as `username`, `email`, and `password`.
   - Helps identify who places orders or manages the cart.

3. **Order Management**
   - Records purchases made by users.
   - An order may contain multiple entries for different products (quantity, product ID, saved price at order time).

4. **Shopping Cart**
   - Allows users to add products before finalizing an order.
   - Automatically calculates the total price (`quantity * product price`) in the service layer.

## Entities (High-Level)

- **Product**
   - Holds product details (ID, name, price).
- **User**
   - Holds user details (ID, username, email, password).
- **Order**
   - Represents individual order lines, each containing a user ID, product ID, quantity, and the per-product price at checkout.
- **ShoppingCart**
   - Represents items a user plans to purchase, calculating total price based on current product price and quantity.

## Typical Workflow

1. **Users** register or are created via the User endpoints.
2. **Products** are managed via the Product endpoints (administration side, possibly).
3. A **Shopping Cart** is used by a user to add products they intend to buy.
4. When ready, the user checks out, creating an **Order** (or multiple order lines) with locked-in prices.

## Endpoints (Example)

- `/api/products` for product CRUD
- `/api/users` for user CRUD
- `/api/orders` for order CRUD
- `/api/carts` for shopping cart CRUD

## Getting Started

1. **Clone** or download this project.
2. **Configure** your database settings (e.g., in `application.properties`).
3. **Build & Run** (e.g., using Maven or Gradle).
4. Access the REST endpoints (default on `http://localhost:8080`).

## Key Points

- **Service-Layer Calculation**:
   - The `ShoppingCart` total price is calculated in the service layer (quantity × product price).
- **Order Price Snapshot**:
   - Orders typically store the product price at purchase time to avoid future price changes affecting past orders.
- **Expandable**:
   - You can integrate security (Spring Security or JWT) to manage authentication.
   - You can introduce an `OrderHeader` entity if you want a more robust design with separate line items.

## Contributing

1. Fork this repository.
2. Create a feature branch.
3. Commit and push your changes.
4. Open a pull request describing the changes.

## License

This project is available under the [MIT License]. You are free to modify and distribute it as needed.
