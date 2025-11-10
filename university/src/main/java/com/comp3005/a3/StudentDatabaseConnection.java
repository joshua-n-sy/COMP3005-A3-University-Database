package com.comp3005.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles PostgreSQL database connections for the student management system.
 */
public class StudentDatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    
    /**
     * Establishes and returns a connection to the PostgreSQL database.
     * @return Connection object if successful, null otherwise. 
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database: ");
            e.printStackTrace();
        }
        return conn;
    }
}
