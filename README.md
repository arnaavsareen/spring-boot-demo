# Spring Boot API Project

## Summary

This project is a Spring Boot REST API for managing persons and their hobbies. I have used the basic structure of the project in the tutorial: https://www.baeldung.com/spring-boot. 

### Project Structure

- The project is organized into distinct modules for `Person` and `Hobby`, each with its own entity, repository, service, and controller.
- Follows REST principles for creating, reading, updating, and deleting resources.
- Uses H2 database for simplicity and ease of setup.
- **Entities**: `Person` (name, hobbies, address, phone) and `Hobby` (name).
- **Repositories**: `PersonRepository` and `HobbyRepository` for CRUD operations.
- **Services**: `PersonService` handles person operations and filtering by hobby; `HobbyService` handles hobby operations.
- **Controllers**: `PersonController` and `HobbyController` manage HTTP requests for their respective resources.

### Main Endpoints

- **Person Endpoints**:
  - `POST /api/v1/persons`: Add a new person.
  - `GET /api/v1/persons`: List all persons.
  - `GET /api/v1/persons/{id}`: Get a person by ID.
  - `PUT /api/v1/persons/{id}`: Update a person.
  - `DELETE /api/v1/persons/{id}`: Delete a person.
  - `GET /api/v1/persons/hobby?hobby={hobby}`: List all persons with a specific hobby.

- **Hobby Endpoints**:
  - `POST /api/v1/hobbies`: Add a new hobby.
  - `GET /api/v1/hobbies`: List all hobbies.
  - `GET /api/v1/hobbies/{id}`: Get a hobby by ID.
  - `PUT /api/v1/hobbies/{id}`: Update a hobby.
  - `DELETE /api/v1/hobbies/{id}`: Delete a hobby.

### Testing with Postman

1. **Add a Person**: `POST /api/v1/persons`
2. **List All Persons**: `GET /api/v1/persons`
3. **Get a Person by ID**: `GET /api/v1/persons/{id}`
4. **Update a Person**: `PUT /api/v1/persons/{id}`
5. **Delete a Person**: `DELETE /api/v1/persons/{id}`
6. **Get All Persons with a Specific Hobby**: `GET /api/v1/persons/hobby?hobby={hobby}`
7. **Add a Hobby**: `POST /api/v1/hobbies`
8. **List All Hobbies**: `GET /api/v1/hobbies`
9. **Get a Hobby by ID**: `GET /api/v1/hobbies/{id}`
10. **Update a Hobby**: `PUT /api/v1/hobbies/{id}`
11. **Delete a Hobby**: `DELETE /api/v1/hobbies/{id}`
