package org.example;

public class Main {
    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Add employees
        Employee emp1 = new Employee(1, "Phani", "HR");
        Employee emp2 = new Employee(2, "Mani", "IT");
        employeeJDBC.addEmployee(emp1);
        employeeJDBC.addEmployee(emp2);

        // Get all employees
        System.out.println("All Employees: " + employeeJDBC.getAllEmployees());

        // Get an employee by id
        Employee employee = employeeJDBC.getEmployeeById(1);
        System.out.println("Employee with id 1: " + employee);

        // Update an employee
        Employee updatedEmployee = new Employee(1, "Chandu", "HR");
        employeeJDBC.updateEmployee(updatedEmployee);
        System.out.println("All Employees after update: " + employeeJDBC.getAllEmployees());

        // Delete an employee
        employeeJDBC.deleteEmployee(2);
        System.out.println("All Employees after deletion: " + employeeJDBC.getAllEmployees());
    }
}
