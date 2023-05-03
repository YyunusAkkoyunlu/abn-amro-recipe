# Recipe API Application

This project contains rest api application created to mannage your recipes.

# About The Project
This Project is developed to manage recipes.This contains an api's to show and perform below actions:
* Show available recipes in with below details
    1. Recipe name
    2. Indicated for vegetarian
    3. How many people the dish is suitable for
    4. Recipe ingredients as list
    5. Recipe cooking instructions

* Create a new ingredient
* Update ingredient
* Delete ingredient
* Display single ingredient    
* Display all ingredients
* Create a new recipe
* Update recipe
* Delete recipe
* Display single recipe
* etc

# Build With
This project has build up with following frameworks and tools/technology used:
* Spring Boot
* Restfull Service
* Java
* H2 as in-memory database
* Springboot validate


# Getting Started
## Prerequisites
	Following are the pre-requisites:
	
	* Intellij IDE
	* Postman

## Installation

	1. Import project
	2. Maven present in project
    3. Enable lombok
	3. Build project and Run as java application 
	4. Use rest service in postman to perform actions

## Example
    1. First we need to create ingredient - POST http://localhost:8080/ingredient/createOrUpdate
```
{
    "name": "beef"
}
```
    2. After ingredient, we need to create recipe - POST http://localhost:8080/recipe/createOrUpdate
```
{
"name": "Spaghetti Bolognese",
"numberOfPerson": 2,
"instructions": "Put a large saucepan on a medium heat and add 1 tbsp olive oil. Add 4 finely chopped bacon rashers and fry for 10 mins until golden and crisp.",
"vegetarian": false,
"ingredients" : [
        {
        "id": 1
        }
    ]

}
```

    3. We can use endpoints help of http://localhost:8080/swagger-ui/index.html
