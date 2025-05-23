# spring-boot-testing-mock-mvc

This project depicts how to write JUnit test cases for Spring boot REST APIs

## Rest Controller

The class `StudentController.java` contains all endpoints.

**AVAILABLE ENDPOINTS**

| method     | resource          | description                                             |
|:-----------|:------------------|:--------------------------------------------------------|
| `GET`			   | `/getMapping`		   | get the collection of students -> 200(OK)														 |
| `POST`		   | `/postMapping`		  | creates a student record -> 201(created)														  |
| `PUT`			   | `/putMapping`	    | updates a student record -> 200(OK)		                   |
| `DELETE`		 | `/deleteMapping`	 | deletes a student record -> 200(OK)		                   |

## Libraries used

- Spring Boot
- Spring Configuration
- Spring REST Controller
- JUnit 5
- Development Tools

## Junit

- This app has mockmvc for the 4 endpoints

## Compilation Command

- `mvn clean install` - Plain maven clean and install

## Medium Article

- Following the article and use this project for Sonar and Code Coverage
  https://medium.com/@reachansari/setting-up-sonarqube-for-java-projects-locally-6111bc56b6fa