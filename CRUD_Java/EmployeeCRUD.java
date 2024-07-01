

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeCRUD {
    private List<Employee> employees;

    // Constructor
    public EmployeeCRUD() {
        employees = new ArrayList<>();
    }

    // Create: Add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Read: Get an employee by id
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employees.stream().filter(e -> e.getId() == id).findFirst();
        return employee.orElse(null);
    }

    // Read: Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // Update: Update an existing employee
    public boolean updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == updatedEmployee.getId()) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                System.out.println("Employee updated: " + employee);
                return true;
            }
        }
        return false;
    }

    // Delete: Remove an employee by id
    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
