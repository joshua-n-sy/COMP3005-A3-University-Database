# COMP3005-A3-University-Database

Assignment 3 - Question 1: Database Interaction with PostgreSQL and Application Programming

A Java-based application that demonstrates how to interact with a PostgreSQL database using JDBC and Maven. This project implements Create, Read, Update, and Delete (CRUD) operations on a students database.

## Overview

The application connects to a PostgreSQL database and performs CRUD operations on a students table. It demonstrates how Java applications communicate with relational databases using JDBC.

## Features
- Retrieve and display all records from the students table
- Insert a new student record into the students table
- Update a student's email address based on their student ID
- Delete a student's record based on their student ID

## Setup Instructions

### Requirements
- Any preferred IDE (e.g., VS Code, IntelliJ IDEA, etc.)
- Apache Maven installed
- Java JDK 21 or compatible version
- PostgreSQL installed and running locally

### Setup Steps
1. Open the project in your IDE.
2. Ensure PostgreSQL is running.
3. Run the provided SQL file to create and populate the database.
4. Update the database credentials in `StudentDatabaseConnection.java` if necessary.
5. Build and run the program using Maven:
   mvn clean compile
   mvn exec:java

## Author
Name: Joshua Sy  
Course: COMP3005A – Database Management Systems  
Institution: Carleton University  
Date: November 9, 2025

## Video Demonstration
A short video demonstration of the project can be viewed here:
[Watch on Youtube](https://youtu.be/5H8OYGPmJ2Y)
