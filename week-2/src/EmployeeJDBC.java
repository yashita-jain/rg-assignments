import java.sql.*;

public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://localhost:3307/EmployeeDB";
    private static final String USER = "root";
    private static final String PASSWORD = "yashita@123";

    // Method to connect to the database
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create Operation
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getDepartment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read Operation
    public Employee getEmployee(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        Employee employee = null;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employee;
    }

    // Update Operation
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getDepartment());
            pstmt.setInt(3, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Operation
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Create a new employee
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        employeeJDBC.addEmployee(emp1);


        // Read an employee
        Employee emp = employeeJDBC.getEmployee(1);
        if (emp != null) {
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Department: " + emp.getDepartment());
        }


        // Update an employee
        emp1.setName("John Smith");
        emp1.setDepartment("Marketing");
        employeeJDBC.updateEmployee(emp1);

        // Delete an employee
        employeeJDBC.deleteEmployee(1);
    }
}
