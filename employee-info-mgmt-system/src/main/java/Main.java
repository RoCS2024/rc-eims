import com.employee.info.mgmt.app.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.info.mgmt.app.model.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static EmployeeFacade employeeFacade = new EmployeeFacadeImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 0:
                    System.out.println("Thank you for using Employee Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("Welcome to Employee Management System");
        System.out.println("1. View All Employees");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("0. Exit");
    }

    private static void viewAllEmployees() {
        List<Employee> employees = employeeFacade.getAllEmployees();
        if (employees != null && !employees.isEmpty()) {
            System.out.println("Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No employees found.");
        }
    }

    private static void addEmployee() {
        Employee employee = getEmployeeDetailsFromUser();
        boolean result = employeeFacade.addEmployee(employee);
        if (result) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
    }

    private static Employee getEmployeeDetailsFromUser() {
        Employee employee = new Employee();
        System.out.print("Enter Last Name: ");
        employee.setLastName(validateStringInput());
        System.out.print("Enter First Name: ");
        employee.setFirstName(validateStringInput());
        System.out.print("Enter Middle Name: ");
        employee.setMiddleName(validateStringInput());
        System.out.print("Enter Position in RC: ");
        employee.setPositionInRC(validateStringInput());
        System.out.print("Enter Date Employed: ");
        employee.setDateEmployed(validateStringInput());
        System.out.print("Birthdate (yyyy-mm-dd hh:mm:ss): ");
        employee.setBirthdate(validateStringInput());
        System.out.print("Birthplace: ");
        employee.setBirthplace(validateStringInput());
        System.out.print("Sex: ");
        employee.setSex(validateStringInput());
        System.out.print("Civil Status: ");
        employee.setCivilStatus(validateStringInput());
        System.out.print("Citizenship: ");
        employee.setCitizenship(validateStringInput());
        System.out.print("Religion: ");
        employee.setReligion(validateStringInput());
        System.out.print("Height (in cm): ");
        employee.setHeight(validateDoubleInput());
        System.out.print("Weight (in kg): ");
        employee.setWeight(validateDoubleInput());
        System.out.print("Email: ");
        employee.setEmail(validateStringInput());
        System.out.print("SSS Number: ");
        employee.setSssNo(validateStringInput());
        System.out.print("TIN Number: ");
        employee.setTinNo(validateStringInput());
        System.out.print("Pagibig Number: ");
        employee.setPagibigNo(validateStringInput());
        System.out.print("Employee Number: ");
        employee.setEmployeeNo(validateStringInput());
        return employee;
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        String employeeId = scanner.nextLine();
        Employee employee = employeeFacade.getEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Select the field to update:");
            System.out.println("1. Last Name");
            System.out.println("2. First Name");
            System.out.println("3. Middle Name");
            System.out.println("4. Position in RC");
            System.out.println("5. Date Employed");
            System.out.println("6. Birthdate");
            System.out.println("7. Birthplace");
            System.out.println("8. Sex");
            System.out.println("9. Civil Status");
            System.out.println("10. Citizenship");
            System.out.println("11. Religion");
            System.out.println("12. Height");
            System.out.println("13. Weight");
            System.out.println("14. Email");
            System.out.println("15. SSS Number");
            System.out.println("16. TIN Number");
            System.out.println("17. Pagibig Number");
            System.out.println("18. Employee Number");



            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new Last Name: ");
                    employee.setLastName(validateStringInput());
                    break;
                case 2:
                    System.out.print("Enter new First Name: ");
                    employee.setFirstName(validateStringInput());
                    break;
                case 3:
                    System.out.print("Enter new Middle Name: ");
                    employee.setMiddleName(validateStringInput());
                    break;
                case 4:
                    System.out.print("Enter Position in RC: ");
                    employee.setPositionInRC(validateStringInput());
                    break;
                case 5:
                    System.out.print("Enter new Date Employed: ");
                    employee.setDateEmployed(validateStringInput());
                    break;
                case 6:
                    System.out.print("Enter new Birthdate: ");
                    employee.setBirthdate(validateStringInput());
                    break;
                case 7:
                    System.out.print("Enter new Birthplace: ");
                    employee.setBirthplace(validateStringInput());
                    break;
                case 8:
                    System.out.print("Enter new Sex: ");
                    employee.setSex(validateStringInput());
                    break;
                case 9:
                    System.out.print("Enter new Civil Status: ");
                    employee.setCivilStatus(validateStringInput());
                    break;
                case 10:
                    System.out.print("Enter new Citizenship: ");
                    employee.setCitizenship(validateStringInput());
                    break;
                case 11:
                    System.out.print("Enter new Religion: ");
                    employee.setReligion(validateStringInput());
                    break;
                case 12:
                    System.out.print("Enter new Height: ");
                    employee.setHeight(validateDoubleInput());
                    break;
                case 13:
                    System.out.print("Enter new Weight: ");
                    employee.setWeight(validateDoubleInput());
                    break;
                case 14:
                    System.out.print("Enter new Email: ");
                    employee.setEmail(validateStringInput());
                    break;
                case 15:
                    System.out.print("Enter new SSS Number: ");
                    employee.setSssNo(validateStringInput());
                    break;
                case 16:
                    System.out.print("Enter new TIN Number: ");
                    employee.setTinNo(validateStringInput());
                    break;
                case 17:
                    System.out.print("Enter new Pagibig Number: ");
                    employee.setPagibigNo(validateStringInput());
                    break;
                case 18:
                    System.out.print("Enter new Employee Number: ");
                    employee.setEmployeeNo(validateStringInput());
                    break;

                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            boolean result = employeeFacade.updateEmployee(employee);
            if (result) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static String validateStringInput() {
        String input;
        do {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter again: ");
            }
        } while (input.isEmpty());
        return input;
    }

    private static double validateDoubleInput() {
        double value = 0;
        boolean valid = false;
        do {
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number: ");
            }
        } while (!valid);
        return value;
    }
}
