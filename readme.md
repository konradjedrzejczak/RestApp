# Restaurant App

This project is a RESTful web application for restaurant management


## Description

The Restaurant App allows users to manage coffees, drinks, users, meals, and orders. It provides endpoints for adding, retrieving, updating, and deleting data related to these entities.
- Adding, viewing, and deleting coffees, drinks, and meals.
- Create an order with a receipt, total calories also confirming, and canceling orders.
- Creating users based on first name, email and phone number.
- CoffeeRatingController allows users to rate coffees available in the app.
- App includes exception handling and data validation mechanisms to ensure correct operation and security of operations.

## Technologies Used
* Java
* Unit Tests
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* PostgreSQL
* Thymeleaf
* CSS
* 
## Installation
1. Clone the repository:
git clone https://github.com/konradjedrzejczak/RestApp
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
* POST /api/meal/ready: Preparation of ready meals.

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
