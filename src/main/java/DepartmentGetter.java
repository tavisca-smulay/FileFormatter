import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentGetter {
    Department departments[];

    public Department[] returnDepartment() throws SQLException {
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Department");
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("select count(*) from Department");
        resultSet1.next();
        int noOfDepartments = resultSet1.getInt(1);
        System.out.println(noOfDepartments);
        departments = new Department[noOfDepartments];
        int i = 0;
        while (resultSet.next()) {
            Department department = new Department();
            department.setDepartmentID(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
            departments[i] = department;
            i++;
        }
        return departments;
    }
}
