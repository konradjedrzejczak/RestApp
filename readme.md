Restaurant App

This project is a simple RESTful web application for managing a restaurant's menu and orders.


Description

The Restaurant App allows users to manage coffees, drinks, users, and orders. It provides endpoints for adding, retrieving, updating, and deleting data related to these entities.

Technologies Used
* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* H2 Database (for development)

Installation
1. Clone the repository:
bashCopy code
git clone https://github.com/yourusername/RestaurantApp.git 
2. Navigate to the project directory:
bashCopy code
cd RestaurantApp 
3. Build the project using Maven:
Copy code
mvn clean install 
4. Run the application:
Copy code
java -jar target/RestaurantApp.jar 

Usage

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

Order Endpoints
* POST /orders: Create a new order

User Endpoints
* POST /api/users: Create a new user
* GET /api/users: Retrieve all users
* GET /api/users/{userId}: Retrieve a user by ID
* DELETE /api/users/{userId}: Delete a user by ID

