import com.update.app.facade.employee.EmployeeFacade;
import com.update.app.facade.employee.impl.EmployeeFacadeImpl;
import com.update.app.model.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacadeImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Showing all Employee...");
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeFacade.getAllEmployee();
        for (Employee employee : employeeList) {
        System.out.println("employee id: " + employee.getEmployeeId() + " | " + employee.getLastName() + " | " + employee.getFirstName() + " | " + employee.getMiddleName() + " | " + employee.getPositionInRc() + " | " +employee.getDateEmployed() + " | " + employee.getBirthdate() + " | " + employee.getBirthplace() + " | " + employee.getSex() + " | " + employee.getCivilStatus()  + " | " + employee.getCitizenship()  + " | " +  employee.getReligion() + " | " + employee.getHeight() + " | " + employee.getWeight()  + " | " + employee.getEmail()  + " | " + employee.getSssNo()  + " | " +  employee.getTinNo() + " | " +  employee.getPagibigNo());
        }

        System.out.println("Searching Employee by Id...");
        System.out.println("Enter search id: ");
        String studentId = sc.nextLine();
        Employee searchEmployee = employeeFacade.getEmployeeById(employeeId);
        if(searchEmployee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("employee id: " + employee.getEmployeeId() + " | " + employee.getLastName() + " | " + employee.getFirstName() + " | " + employee.getMiddleName() + " | " + employee.getPositionInRc() + " | " +employee.getDateEmployed() + " | " + employee.getBirthdate() + " | " + employee.getBirthplace() + " | " + employee.getSex() + " | " + employee.getCivilStatus()  + " | " + employee.getCitizenship()  + " | " +  employee.getReligion() + " | " + employee.getHeight() + " | " + employee.getWeight()  + " | " + employee.getEmail()  + " | " + employee.getSssNo()  + " | " +  employee.getTinNo() + " | " +  employee.getPagibigNo());
        }
    }
}

