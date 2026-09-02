# Library System

A console-based library management system developed in Java to practice Object-Oriented Programming, collections, exception handling, and software design.

## About

Library System is a study project created to reinforce Java fundamentals through the development of a small but complete domain model.

The project focuses not only on making the system work, but also on understanding how classes interact, how responsibilities are distributed, and how business rules can be represented through object-oriented design.

## Features

- Register books
- Search books by code
- Search books by title
- Search books by author
- Borrow books
- Return books
- List all books
- List a student's loans
- Validate book availability
- Handle domain-specific exceptions

## Domain Model

The main entities of the system are:

- **Book** — represents a book and its availability status.
- **Student** — represents a library student and keeps track of their loans.
- **Loan** — represents the relationship between a student and a borrowed book.
- **Library** — manages books and students.

The project uses these relationships to practice responsibility separation and object composition.

## Concepts Practiced

- Object-Oriented Programming
- Classes and objects
- Encapsulation
- Constructors
- Getters and setters
- Object relationships
- Collections
- `List`
- `Map`
- Enums
- `LocalDate`
- Exception handling
- Custom runtime exceptions
- Domain validation
- `toString()` overriding
- Basic software design and responsibility separation

## Technologies

- Java
- IntelliJ IDEA
- Git
- GitHub

## Project Structure

```text
src/
├── application/
│   └── Program.java
│
└── model/
    ├── entities/
    │   ├── Book.java
    │   ├── Library.java
    │   ├── Loan.java
    │   └── Student.java
    │
    ├── enums/
    │   └── BookStatus.java
    │
    └── exceptions/
        └── DomainException.java
