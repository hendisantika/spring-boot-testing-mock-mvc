# spring-boot-testing-mock-mvc

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-testing-mock-mvc/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-testing-mock-mvc/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-brightgreen?logo=springboot)
![Dependabot](https://img.shields.io/badge/Dependabot-enabled-blue?logo=dependabot)

This project shows how to write JUnit test cases for Spring Boot REST APIs using `MockMvc`.

## Tech Stack

- Java 25
- Spring Boot 4.1.x (Spring Web MVC)
- Jackson 3 (`tools.jackson`)
- Lombok
- JUnit 5, Mockito & `MockMvc` (`spring-boot-starter-webmvc-test`)
- JaCoCo for code coverage
- Maven (via the Maven Wrapper)

## Rest Controller

The class `StudentController.java` contains all endpoints.

**AVAILABLE ENDPOINTS**

| Method   | Resource                         | Description                               |
|:---------|:---------------------------------|:------------------------------------------|
| `GET`    | `/api/students`                  | get the collection of students -> 200 (OK) |
| `POST`   | `/api/students`                  | creates a student record -> 201 (Created) |
| `PUT`    | `/api/students`                  | updates a student record -> 200 (OK)      |
| `DELETE` | `/api/students?student-id={id}`  | deletes a student record -> 200 (OK)      |

## Tests

`StudentControllerTest` uses `@SpringBootTest` + `@AutoConfigureMockMvc` to cover all 4 endpoints, with
`StudentService` replaced by a Mockito mock.

> **Spring Boot 4 note:** `@AutoConfigureMockMvc` now lives in
> `org.springframework.boot.webmvc.test.autoconfigure` and requires the `spring-boot-starter-webmvc-test`
> dependency. Jackson's `ObjectMapper` moved to `tools.jackson.databind`.

## Prerequisites

- JDK 25 (e.g. [Eclipse Temurin 25](https://adoptium.net/))
- No local Maven install needed — use the bundled `./mvnw`

## Build & Run

```shell
# Build, run the tests and generate the JaCoCo report (target/site/jacoco/index.html)
./mvnw clean package

# Run tests only
./mvnw test

# Start the application (http://localhost:8080)
./mvnw spring-boot:run
```

Try it out:

```shell
curl http://localhost:8080/api/students
```

## Continuous Integration

GitHub Actions ([`.github/workflows/maven.yml`](.github/workflows/maven.yml)) builds and tests the project on
Temurin JDK 25 for every push and pull request to `main`, and can also be triggered manually. Pushes to `main`
also submit the Maven dependency graph to GitHub to improve Dependabot alerts.

## Dependency Updates

[Dependabot](.github/dependabot.yml) checks daily (05:00 Asia/Jakarta) for:

- **Maven** dependencies, plugins and the Maven wrapper, grouped into `spring-boot`, `test` and `maven-plugins`
  (minor/patch) update PRs, using `build(deps)` / `build(deps-dev)` commit prefixes.
- **GitHub Actions** versions, grouped into a single PR, using the `ci(deps)` commit prefix.

All Dependabot PRs are labelled `dependencies` plus `java` or `github_actions`.

## Medium Article

- Follow this article to use this project with SonarQube and code coverage:
  https://medium.com/@reachansari/setting-up-sonarqube-for-java-projects-locally-6111bc56b6fa
