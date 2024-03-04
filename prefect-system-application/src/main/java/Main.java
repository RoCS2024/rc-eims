import com.prefect.system.app.facade.EmployeeFacade;
import com.prefect.system.app.facade.Impl.EmployeeFacadeImpl;
import com.prefect.system.app.model.Employee;

import java.util.List;
import java.util.Scanner;

/**
 * This is for need to view employee table.
 */

public class Main {
    private static EmployeeFacade employeeFacade = new EmployeeFacadeImpl();
    private static Scanner sc = new Scanner(System.in);
    private static final String USERNAME = "rogate";
    private static final String PASSWORD = "Changeme0";


    /**
     * The main method is the entry point of the application.
     * It prompts the user for authentication and then displays the menu.
     */
    public static void main(String[] args) {
        authorizedUser();
    }
    /**
     * Authenticates the user by prompting for a username and password.
     * If the credentials are correct, it displays the main menu.
     */

    private static void authorizedUser() {

            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                showMenu();
            } else {
                System.out.println("Invalid username or password. Please try again.");
                authorizedUser();
            }
        }

    /**
     * Displays the main menu and handles user input.
     */

         private static void showMenu(){
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewEmployeeTable();
                    break;
                case 2:
                    searchEmployeeId();
                    break;
                case 0:
                    System.out.println("Exiting Employee Table.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }


    /**
     * Displays the menu options.
     */
    private static void displayMenu() {
        System.out.println("Employee System Menu");
        System.out.println("1. View Employee Table");
        System.out.println("2. Search Employee by ID");
        System.out.println("0. Exit");
    }

    /**
     * Retrieves and displays the list of all employees.
     */
    private static void viewEmployeeTable() {
        System.out.println("SHOWING ALL ITEMS....");
        List<Employee> employeeList = employeeFacade.getAllEmployees();
        for (Employee employee : employeeList) {
            System.out.println(
                            employee.getLastName() + "', '" +
                            employee.getFirstName() + "', '" +
                            employee.getMiddleName() + "', '" +
                            employee.getPositionInRc() + "', '" +
                            employee.getDateEmployed() + "', '" +
                            employee.getBirthdate() + "', '" +
                            employee.getBirthplace() + "', '" +
                            employee.getSex() + "', '" +
                            employee.getCivilStatus() + "', ' " +
                            employee.getCitizenship() + "', '" +
                            employee.getReligion() + "', '" +
                            employee.getHeight() + "', '" +
                            employee.getWeight() + "', '" +
                            employee.getEmail() + "', '" +
                            employee.getSssNo() + "', '" +
                            employee.getTinNo() + "', '" +
                            employee.getPagibigNo() + "','" +
                            employee.getEmployeeNo() + "');");
        }
    }

    /**
     * Searches for an employee by ID and displays their information.
     */
    private static void searchEmployeeId() {
        System.out.println("ENTER SEARCH ID....");
        String no = sc.nextLine();
        Employee searchEmployee = employeeFacade.getEmployeeByNo(no);
        if (searchEmployee == null) {
            System.out.println("Employee not found");
        } else {
            System.out.println(
                            searchEmployee.getLastName() + "', '" +
                            searchEmployee.getFirstName() + "', '" +
                            searchEmployee.getMiddleName() + "', '" +
                            searchEmployee.getPositionInRc() + "', '" +
                            searchEmployee.getDateEmployed() + "', '" +
                            searchEmployee.getBirthdate() + "', '" +
                            searchEmployee.getBirthplace() + "', '" +
                            searchEmployee.getSex() + "', '" +
                            searchEmployee.getCivilStatus() + "', ' " +
                            searchEmployee.getCitizenship() + "', '" +
                            searchEmployee.getReligion() + "', '" +
                            searchEmployee.getHeight() + "', '" +
                            searchEmployee.getWeight() + "', '" +
                            searchEmployee.getEmail() + "', '" +
                            searchEmployee.getSssNo() + "', '" +
                            searchEmployee.getTinNo() + "', '" +
                            searchEmployee.getPagibigNo() + "','" +
                            searchEmployee.getEmployeeNo() + "');");
        }
    }
}
