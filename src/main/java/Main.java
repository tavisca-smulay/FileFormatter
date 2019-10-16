import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, FolderCantBeCreatedException, ClassNotFoundException {
        Connection connection = DatabaseConnector.connect();
        EmployeeGetter employeeGetter = new EmployeeGetter();
        DepartmentGetter departmentGetter = new DepartmentGetter();
        Employee employeeList[]= employeeGetter.returnEmployee();
        Department departmentList[]= departmentGetter.returnDepartment();

        System.out.println("Please enter the format: ");
        Scanner sc = new Scanner(System.in);
        String format = sc.next();
        System.out.println("Please enter location");
        String location = sc.next();
        sc.close();

        switch(format){
            case "XML":
                XMLSerializer xmlSerializer = new XMLSerializer();
                xmlSerializer.serializeToXML(employeeList, location);
                break;
            case "JSON":
                JSONSerializer jsonSerializer = new JSONSerializer();
                jsonSerializer.serializeToJSON(employeeList);
                break;
            case "CSV":
                CSVSerializer csvSerializer = new CSVSerializer();
                csvSerializer.serializeToCSV(employeeList);
                break;
            default:
            {
                System.out.println("Please enter valid format!! (XML/JSON/CSV)");
            }
        }

       /*
        TableJoiner tableJoiner = new TableJoiner();
        tableJoiner.joinTable(employeeList, departmentList);
        */
        connection.close();
    }
}
