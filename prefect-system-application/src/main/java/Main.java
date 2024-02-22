import com.prefect.system.app.facade.EmployeeFacade;
import com.prefect.system.app.facade.Impl.EmployeeFacadeImpl;
import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.Impl.EmployeeDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    private static final EmployeeFacade employeeFacade = new EmployeeFacadeImpl(new EmployeeDaoImpl());


    public static void main(String[] args) {
        int choice;
        do {
            displayMenu ();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewEmployeeTable();
                    break;
                case 0:
                    System.out.println("Exiting Infirmary System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Employee Prefect System Menu");
        System.out.println("1. View Employee Table");
        System.out.println("0. Exit");
    }
    private static void viewEmployeeTable() {
        try {
            List<Employee> employ = employeeFacade.getAllEmployees();

            if (employ.isEmpty()) {
                System.out.println("No records found in employee table.");
            } else {
                for (Employee employee : employ) {
                    System.out.printf("%-10s %-15s %-15s %-15s %-25s %-20s %-32s %-15s %-15s %-15s %-15s %-10s %-10s %-20s %-16s %-16s %-16s %-16s%n",
                            employee.getLastName(), employee.getFirstName(), employee.getMiddleName(),
                            employee.getPositionInRc(), employee.getDateEmployed(), employee.getBirthdate(),
                            employee.getBirthplace(), employee.getSex(), employee.getCivilStatus(),
                            employee.getCitizenship(), employee.getReligion(), employee.getHeight(),
                            employee.getWeight(), employee.getEmail(), employee.getSssNo(),
                            employee.getTinNo(), employee.getPagibigNo(), employee.getEmployeeId());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error viewing employee table. Please try again.");
            e.printStackTrace();
        }
    }

}
