public class EmployeeAndDepartment extends Employee{
    Department department;
    private String departmentName;

    public EmployeeAndDepartment(int employeeID, String employeeName, int departmentID, int salary){
        super(employeeID, employeeName, departmentID, salary);
    }

    public String getDepartmentName() {
        department = new Department();
        return department.getDepartmentName();
    }

}
