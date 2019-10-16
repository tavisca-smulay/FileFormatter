public class Employee {
    private int employeeID;
    private String employeeName;
    private int departmentID;
    private int salary;

    public Employee() {

    }

    public Employee(int employeeID, String employeeName, int departmentID, int salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.departmentID = departmentID;
        this.salary = salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "EmployeeID=" + employeeID +
                ", EmployeeName='" + employeeName + '\'' +
                '}';
    }
}
