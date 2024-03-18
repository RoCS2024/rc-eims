import com.employee.info.mgmt.app.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.info.mgmt.app.model.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static EmployeeFacade employeeFacade = new EmployeeFacadeImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            logger.info("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            try {
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
                        logger.info("Thank you for using Employee Management System!");
                        break;
                    default:
                        logger.warning("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                logger.warning("An error occurred: " + e.getMessage());
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        logger.info("Welcome to Employee Management System");
        logger.info("1. View All Employees");
        logger.info("2. Add Employee");
        logger.info("3. Update Employee");
        logger.info("0. Exit");
    }

    private static void viewAllEmployees() {
        try {
            List<Employee> employees = employeeFacade.getAllEmployees();
            if (employees != null && !employees.isEmpty()) {
                logger.info("Employees:");
                for (Employee employee : employees) {
                    logger.info(employee.toString());
                }
            } else {
                logger.warning("No employees found.");
            }
        } catch (Exception e) {
            logger.warning("Error fetching employees: " + e.getMessage());
        }
    }

    private static void addEmployee() {
        try {
            Employee employee = getEmployeeDetailsFromUser();
            boolean result = employeeFacade.addEmployee(employee);
            if (result) {
                logger.info("Employee added successfully." + employee);
            } else {
                logger.warning("Failed to add employee." + employee);
            }
        } catch (Exception e) {
            logger.warning("Error adding employee: " + e.getMessage());
        }
    }

    private static Employee getEmployeeDetailsFromUser() {
        Employee employee = new Employee();
        logger.info("Enter Last Name: ");
        employee.setLastName(validateStringInput());
        logger.info("Enter First Name: ");
        employee.setFirstName(validateStringInput());
        logger.info("Enter Middle Name: ");
        employee.setMiddleName(validateStringInput());
        logger.info("Enter Position in RC: ");
        employee.setPositionInRC(validateStringInput());
        logger.info("Enter Date Employed: ");
        employee.setDateEmployed(validateStringInput());
        logger.info("Birthdate (yyyy-mm-dd hh:mm:ss): ");
        employee.setBirthdate(validateStringInput());
        logger.info("Birthplace: ");
        employee.setBirthplace(validateStringInput());
        logger.info("Sex: ");
        employee.setSex(validateStringInput());
        logger.info("Civil Status: ");
        employee.setCivilStatus(validateStringInput());
        logger.info("Citizenship: ");
        employee.setCitizenship(validateStringInput());
        logger.info("Religion: ");
        employee.setReligion(validateStringInput());
        logger.info("Height (in cm): ");
        employee.setHeight(validateDoubleInput());
        logger.info("Weight (in kg): ");
        employee.setWeight(validateDoubleInput());
        logger.info("Email: ");
        employee.setEmail(validateStringInput());
        logger.info("SSS Number: ");
        employee.setSssNo(validateStringInput());
        logger.info("TIN Number: ");
        employee.setTinNo(validateStringInput());
        logger.info("Pagibig Number: ");
        employee.setPagibigNo(validateStringInput());
        logger.info("Employee Number: ");
        employee.setEmployeeNo(validateStringInput());
        return employee;
    }

    private static void updateEmployee() {
        try {
            System.out.print("Enter employee ID to update: ");
            String employeeId = scanner.nextLine();
            Employee employee = employeeFacade.getEmployeeById(employeeId);
            if (employee != null) {
                logger.info("Select the field to update:");
                logger.info("1. Last Name");
                logger.info("2. First Name");
                logger.info("3. Middle Name");
                logger.info("4. Position in RC");
                logger.info("5. Date Employed");
                logger.info("6. Birthdate");
                logger.info("7. Birthplace");
                logger.info("8. Sex");
                logger.info("9. Civil Status");
                logger.info("10. Citizenship");
                logger.info("11. Religion");
                logger.info("12. Height");
                logger.info("13. Weight");
                logger.info("14. Email");
                logger.info("15. SSS Number");
                logger.info("16. TIN Number");
                logger.info("17. Pagibig Number");
                logger.info("18. Employee Number");


                logger.info("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        logger.info("Enter new Last Name: ");
                        employee.setLastName(validateStringInput());
                        break;
                    case 2:
                        logger.info("Enter new First Name: ");
                        employee.setFirstName(validateStringInput());
                        break;
                    case 3:
                        logger.info("Enter new Middle Name: ");
                        employee.setMiddleName(validateStringInput());
                        break;
                    case 4:
                        logger.info("Enter Position in RC: ");
                        employee.setPositionInRC(validateStringInput());
                        break;
                    case 5:
                        logger.info("Enter new Date Employed: ");
                        employee.setDateEmployed(validateStringInput());
                        break;
                    case 6:
                        logger.info("Enter new Birthdate: ");
                        employee.setBirthdate(validateStringInput());
                        break;
                    case 7:
                        logger.info("Enter new Birthplace: ");
                        employee.setBirthplace(validateStringInput());
                        break;
                    case 8:
                        logger.info("Enter new Sex: ");
                        employee.setSex(validateStringInput());
                        break;
                    case 9:
                        logger.info("Enter new Civil Status: ");
                        employee.setCivilStatus(validateStringInput());
                        break;
                    case 10:
                        logger.info("Enter new Citizenship: ");
                        employee.setCitizenship(validateStringInput());
                        break;
                    case 11:
                        logger.info("Enter new Religion: ");
                        employee.setReligion(validateStringInput());
                        break;
                    case 12:
                        logger.info("Enter new Height: ");
                        employee.setHeight(validateDoubleInput());
                        break;
                    case 13:
                        logger.info("Enter new Weight: ");
                        employee.setWeight(validateDoubleInput());
                        break;
                    case 14:
                        logger.info("Enter new Email: ");
                        employee.setEmail(validateStringInput());
                        break;
                    case 15:
                        logger.info("Enter new SSS Number: ");
                        employee.setSssNo(validateStringInput());
                        break;
                    case 16:
                        logger.info("Enter new TIN Number: ");
                        employee.setTinNo(validateStringInput());
                        break;
                    case 17:
                        logger.info("Enter new Pagibig Number: ");
                        employee.setPagibigNo(validateStringInput());
                        break;
                    case 18:
                        logger.info("Enter new Employee Number: ");
                        employee.setEmployeeNo(validateStringInput());
                        break;

                    default:
                        logger.warning("Invalid choice.");
                        return;
                }

                boolean result = employeeFacade.updateEmployee(employee);
                if (result) {
                    logger.info("Employee updated successfully.");
                } else {
                    logger.warning("Failed to update employee.");
                }
                } else {
                logger.warning("Employee not found.");
                }
        } catch (Exception e) {
            logger.warning("Error updating employee: " + e.getMessage());
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
                logger.warning("Invalid input. Please enter a valid number: ");
            }
        } while (!valid);
        return value;
    }
}