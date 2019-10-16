import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeGetter {
    Employee employees[];
    public Employee[] returnEmployee() throws SQLException {
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Employees");
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("select count(*) from Employees");
        resultSet1.next();
        int noOfEmployees = resultSet1.getInt(1);
        System.out.println(noOfEmployees);
        employees= new Employee[noOfEmployees];
        int i = 0;
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeID(resultSet.getInt(1));
            employee.setEmployeeName(resultSet.getString(2));
            employee.setDepartmentID(resultSet.getInt(5));
            employee.setSalary(resultSet.getInt(4));
            employees[i] = employee;
            i++;
        }
        return employees;
    }
}