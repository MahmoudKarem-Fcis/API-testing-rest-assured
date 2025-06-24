# User Management API Testing

This project is a Java-based test automation framework for testing the User Management API provided by [Reqres](https://reqres.in). It uses **RestAssured** for API testing and **TestNG** for test execution.

## Features

- Automated API tests for creating, retrieving, and updating users.
- Configuration management using `config.properties`.
- Utility methods for validating API responses.
- Maven-based project structure for easy dependency management.

## Prerequisites

- Java 8 or higher
- Maven
- IntelliJ IDEA or any Java IDE
- Internet connection (to access the Reqres API)

### Key Files

- **`ConfigManager.java`**: Manages configuration properties.
- **`ApiUtils.java`**: Provides utility methods for API response validation.
- **`UserTests.java`**: Contains test cases for user creation, retrieval, and update.
- **`config.properties`**: Stores configuration values like the base URL.

## Dependencies

The project uses the following dependencies:

- [RestAssured](https://rest-assured.io): For API testing.
- [TestNG](https://testng.org): For test execution and assertions.

Dependencies are managed via Maven. See the `pom.xml` file for details.

