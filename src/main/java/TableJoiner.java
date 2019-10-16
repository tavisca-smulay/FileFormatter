import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TableJoiner{
    public void joinTable(Employee employeeArray[], Department departmentArray[]) throws SQLException {

        List<Employee> employeeList = Arrays.asList(employeeArray);
        List<Department> departmentList = Arrays.asList(departmentArray);

        /* Map<Integer, Department> departmentMap = new HashMap<>();
        for (Department department : departmentList) {
            departmentMap.put(department.getDepartmentID(), department);
        } */

        List<EmployeeAndDepartment> employeeAndDepartmentList = Stream.concat(employeeList.stream(), departmentList.stream())
                .filter()
                .collect(Collectors.toList());
   }
}
