# Restaurant App

This project is a simple RESTful web application for managing a restaurant's menu and orders.


## Description

The Restaurant App allows users to manage coffees, drinks, users, meals, and orders. It provides endpoints for adding, retrieving, updating, and deleting data related to these entities.
- Adding, viewing, and deleting coffees, drinks, and meals.
- Creating, confirming, and canceling orders.
- Managing customers.
- CoffeRatingController allows users to rate coffees available in the app.

## Technologies Used
* Java
* Unit Tests
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* PostgreSQL

## Installation
1. Clone the repository:
git clone https://github.com/yourusername/RestaurantApp.git 
2. Navigate to the project directory:
cd RestaurantApp 
3. Build the project using Maven:
mvn clean install 
4. Run the application:
java -jar target/RestaurantApp.jar 

## Usage

Once the application is running, you can access the API endpoints using tools like cURL, Postman, or any web browser.

Coffee Endpoints

* GET /api/coffees: Retrieve all coffees
* GET /api/coffees/{id}: Retrieve a coffee by ID
* POST /api/coffees: Add a new coffee
* POST /api/coffees/espresso: Brew espresso
* POST /api/coffees/latte: Brew latte
* DELETE /api/coffees/{coffeeId}: Delete a coffee by ID

Drink Endpoints
* GET /api/drink: Retrieve all drinks
* POST /api/drink: Add a new drink
* DELETE /api/drink/{drinkId}: Delete a drink by ID

Meal Endpoints
* POST /api/meal/add: Add a new meal.
* GET /api/meal: Get all meals.
* GET /api/meal/{id}: Get a meal by ID.
* POST /api/meal/ready: Mark meals as ready.

Order Endpoints
* POST /orders: Create a new order
* POST /orders/{orderId}/confirm: Confirm an order.
* POST /orders/{orderId}/cancel: Cancel an order.
* GET /orders: Get all orders.
* GET /orders/{id}: Get an order by ID.

User Endpoints
* POST /api/users: Create a new user
* GET /api/users: Retrieve all users
* GET /api/users/{userId}: Retrieve a user by ID
* DELETE /api/users/{userId}: Delete a user by ID

Coffee Rating Endpoints
* POST /api/ratings: Add a new rating for coffee
