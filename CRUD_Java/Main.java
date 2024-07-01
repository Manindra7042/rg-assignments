public class Main {
    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        // Add employees
        Employee emp1 = new Employee(1, "Phani", "HR");
        Employee emp2 = new Employee(2, "Mani", "IT");
        employeeCRUD.addEmployee(emp1);
        employeeCRUD.addEmployee(emp2);

        // Get all employees
        System.out.println("All Employees: " + employeeCRUD.getAllEmployees());

        // Get an employee by id
        Employee employee = employeeCRUD.getEmployeeById(1);
        System.out.println("Employee with id 1: " + employee);

        // Update an employee
        Employee updatedEmployee = new Employee(1, "Chandu", "HR");
        employeeCRUD.updateEmployee(updatedEmployee);
        System.out.println("All Employees after update: " + employeeCRUD.getAllEmployees());

        // Delete an employee
        employeeCRUD.deleteEmployee(2);
        System.out.println("All Employees after deletion: " + employeeCRUD.getAllEmployees());
    }
}
