# Library Management System (LMS)

A simple command-line based Library Management System built with Java and Maven.

## Overview

This project provides a basic Command Line Interface (CLI) application to manage a library. It allows you to manage books and members through different architectural layers (Model, Repository, Service, and CLI).

## Prerequisites

- Java 17 or higher
- Maven 3.x

## Project Structure

- `com.lms.model`: Contains data models like Book and Member.
- `com.lms.repository`: Data access layer for managing in-memory or persistent storage.
- `com.lms.service`: Business logic layer (e.g., Library service).
- `com.lms.cli`: Command-line interface for user interaction.
- `com.lms.exception`: Custom exceptions for error handling.

## Build and Run

To compile the project and build the JAR file, run:
```bash
mvn clean install
```

To execute the application:
```bash
mvn exec:java -Dexec.mainClass="com.lms.App"
```

## Testing

The project uses JUnit 5 for testing. To run tests, execute:
```bash
mvn test
```
