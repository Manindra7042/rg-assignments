package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASSWORD = "Saimohan@7042"; // Change to your MySQL password

    // Create: Add a new employee
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getDepartment());

            stmt.executeUpdate();
            System.out.println("Employee added: " + employee);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read: Get an employee by id
    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM Employee WHERE id = ?";
        Employee employee = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Read: Get all employees
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM Employee";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update: Update an existing employee
    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
        boolean rowUpdated = false;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            stmt.setInt(3, employee.getId());

            rowUpdated = stmt.executeUpdate() > 0;
            if (rowUpdated) {
                System.out.println("Employee updated: " + employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Delete: Remove an employee by id
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE id = ?";
        boolean rowDeleted = false;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
            if (rowDeleted) {
                System.out.println("Employee deleted with id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
