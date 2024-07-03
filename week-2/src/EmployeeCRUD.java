import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeCRUD {
    private List<Employee> employeeList;

    public EmployeeCRUD() {
        this.employeeList = new ArrayList<>();
    }

    // Create (Add) Operation
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Read (Retrieve) Operation
    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        return optionalEmployee.orElse(null);
    }

    // Update Operation
    public void updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employeeList) {
            if (employee.getId() == updatedEmployee.getId()) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                break;
            }
        }
    }

    // Delete Operation
    public void deleteEmployee(int id) {
        employeeList.removeIf(e -> e.getId() == id);
    }

    // Display All Employees
    public void displayAllEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // Example of usage in main method
    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        // Adding employees
        employeeCRUD.addEmployee(new Employee(1, "John Doe", "IT"));
        employeeCRUD.addEmployee(new Employee(2, "Jane Smith", "HR"));

        // Display all employees
        System.out.println("All Employees:");
        employeeCRUD.displayAllEmployees();

        // Update an employee
        Employee updatedEmployee = new Employee(2, "Jane Smith", "Finance");
        employeeCRUD.updateEmployee(updatedEmployee);

        // Display all employees after update
        System.out.println("\nAll Employees after Update:");
        employeeCRUD.displayAllEmployees();

        // Delete an employee
        employeeCRUD.deleteEmployee(1);

        // Display all employees after delete
        System.out.println("\nAll Employees after Delete:");
        employeeCRUD.displayAllEmployees();
    }
}
