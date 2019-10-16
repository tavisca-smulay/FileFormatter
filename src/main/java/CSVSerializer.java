import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVSerializer {
    public void serializeToCSV(Employee employee[]){
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("third.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("EmployeeID", "EmployeeName", "DepartmentID", "Salary"));
            for(Employee employee1 : employee){
                List<String> employeeList = new ArrayList<>();
                employeeList.add(String.valueOf(employee1.getEmployeeID()));
                employeeList.add(employee1.getEmployeeName());
                employeeList.add(String.valueOf(employee1.getDepartmentID()));
                employeeList.add(String.valueOf(employee1.getSalary()));
                csvPrinter.printRecord(employeeList);
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}