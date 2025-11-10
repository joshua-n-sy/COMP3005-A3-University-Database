package com.comp3005.a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides CRUD (Create, Read, Update, Delete) operations for the students table.
 * Uses JDBC to interact with the PostgreSQL database.
 */
public class StudentRepository {
    /**
     * Retrieves and returns all records from the students table.
     * @return List of student records.
     */ 
    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = StudentDatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(rs.getInt("student_id") + " - " +
                             rs.getString("first_name") + " " +
                             rs.getString("last_name") + " - " +
                             rs.getString("email") + " - " +
                             rs.getDate("enrollment_date").toString());
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: ");
            e.printStackTrace();
        }
        return students;
    }

    /**
     * Inserts a new student record into the students table.
     * @param first_name The student's first name
     * @param last_name The student's last name
     * @param email The student's email address
     * @param enrollement_date The student's enrollment date
     */
    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        String sql = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = StudentDatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setDate(4, java.sql.Date.valueOf(enrollment_date));
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: ");
            e.printStackTrace();
        }
    }

    /**
     * Updates a student's email address based on their student ID.
     * @param student_id The ID of the student to update
     * @param new_email The new email address to set
     */
    public void updateStudentEmail(int student_id, String new_email) {
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";

        try (Connection conn = StudentDatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);
            pstmt.executeUpdate();
            System.out.println("Email updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating email: ");
            e.printStackTrace();
        }
    }

    /**
     * Deletes a student record based on their student ID.
     * @param student_id The ID of the student to delete
     */
    public void deleteStudent(int student_id) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = StudentDatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting student: ");
            e.printStackTrace();
        }
    }
}
