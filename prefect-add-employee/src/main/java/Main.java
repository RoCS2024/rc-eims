import com.add.employee.app.facade.employee.impl.EmployeeFacadeImpl;
import com.add.employee.app.model.employee.Employee;
import com.add.employee.data.connection.ConnectionHelper;
import com.add.employee.data.employee.dao.EmployeeDao;
import com.add.employee.data.employee.dao.impl.EmployeeDaoImpl;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);

        System.out.println("Enter Employee Details:");

        Employee employee = new Employee();

        System.out.print("Last Name: ");
        employee.setLastName(scanner.nextLine());
        System.out.print("First Name: ");
        employee.setFirstName(scanner.nextLine());
        System.out.print("Middle Name: ");
        employee.setMiddleName(scanner.nextLine());
        System.out.print("Position in RC: ");
        employee.setPositionInRC(scanner.nextLine());
        System.out.print("Date Employed: ");
        employee.setDateEmployed(scanner.nextLine());
        System.out.print("Birthdate: ");
        employee.setBirthdate(scanner.nextLine());
        System.out.print("Birthplace: ");
        employee.setBirthplace(scanner.nextLine());
        System.out.print("Sex: ");
        employee.setSex(scanner.nextLine());
        System.out.print("Civil Status: ");
        employee.setCivilStatus(scanner.nextLine());
        System.out.print("Citizenship: ");
        employee.setCitizenship(scanner.nextLine());
        System.out.print("Religion: ");
        employee.setReligion(scanner.nextLine());
        System.out.print("Height (in cm): ");
        employee.setHeight(scanner.nextDouble());
        System.out.print("Weight (in kg): ");
        employee.setWeight(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("SSS Number: ");
        employee.setSssNo(scanner.nextLine());
        System.out.print("TIN Number: ");
        employee.setTinNo(scanner.nextLine());
        System.out.print("Pagibig Number: ");
        employee.setPagibigNo(scanner.nextLine());
        System.out.print("Employee Phone Number: ");
        employee.setEmployeeNo(scanner.nextLine());

        employeeFacade.addEmployee(employee);

        scanner.close();
        Connection con = ConnectionHelper.getConnection();
    }
}
