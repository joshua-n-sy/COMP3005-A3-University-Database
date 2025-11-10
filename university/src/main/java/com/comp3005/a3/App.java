package com.comp3005.a3;

/**
 * Assignment 3 Question 1
 * Application: University Database Management System
 *
 * Description:
 *  This program demonstrates basic CRUD (Create, Read, Update, Delete)
 *  operations on a PostgreSQL students table using JDBC.
 *
 * Author: Joshua Sy
 * Course: COMP3005A - Database Management Systems
 * Institution: Carleton University
 * Date: November 9, 2025
 *
 * Notes:
 *  - Requires PostgreSQL running locally on port 5432.
 *  - Update StudentDatabaseConnection.java for database credentials.
 *  - To run:
 *      mvn clean compile
 *      mvn exec:java
 */
public class App {
    public static void main( String[] args ) {
        StudentRepository repo = new StudentRepository();

        System.out.println("=========================================");
        System.out.println("      COMP 3005 - Assignment 3 Demo");
        System.out.println("           CRUD Operations Test");
        System.out.println("=========================================\n");

        System.out.println("Starting CRUD operation tests.");

        // Retrieve and display all records from the students table.
        System.out.println("\nRetrieving all students...");
        repo.getAllStudents().forEach(System.out::println);

        // Insert a new student record into the students table.
        System.out.println("\nAdding New Student...");
        repo.addStudent("Joshua", "Sy", "joshua.sy@example.com", "2025-11-09");
        repo.getAllStudents().forEach(System.out::println);

        // Update a student's email address based on their student ID.
        System.out.println("\nUpdating student email...");
        repo.updateStudentEmail(4, "new.email@example.com");
        repo.getAllStudents().forEach(System.out::println);

        // Delete a student's record based on their student ID.
        System.out.println("\nDeleting student... ");
        repo.deleteStudent(4);
        repo.getAllStudents().forEach(System.out::println);

        System.out.println("\nAll CRUD operation tests complete.");
    }
}
