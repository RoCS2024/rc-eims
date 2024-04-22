import com.employee.info.mgmt.appl.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.appl.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import com.employee.info.mgmt.data.employee.dao.impl.EmployeeDaoImpl;

import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static EmployeeFacade employeeFacade;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeFacade = new EmployeeFacadeImpl(employeeDao);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
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
                        System.out.println("Thank you for using Employee Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
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
        System.out.println("Showing all Employees ...");
        try {
            List<Employee> employeeList = employeeFacade.getAllEmployees();

            if (employeeList != null && !employeeList.isEmpty()) {
                for (Employee employee : employeeList) {
                    System.out.println("Employee ID: " + employee.getEmployeeNo());
                    System.out.println("Full Name: " + employee.getLastName() + ", " + employee.getFirstName() + ", " + employee.getMiddleName());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No employee records found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while viewing all employee: " + e.getMessage());
        }
    }

    private static void addEmployee() {
        try {
            Employee employee = getEmployeeDetailsFromUser();
            boolean result = employeeFacade.addEmployee(employee);
            if (result) {
                System.out.println("Employee added successfully.");
            } else {
                System.out.println("Failed to add employee.");
            }
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
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
        System.out.print("Enter Date Employed (yyyy-mm-dd hh:mm:ss): ");
        employee.setDateEmployed(validateTimestampInput());
        System.out.print("Enter Birthdate (yyyy-mm-dd hh:mm:ss): ");
        employee.setBirthdate(validateTimestampInput());
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
        employee.setEmail(validateEmailInput());
        System.out.print("SSS Number: ");
        employee.setSssNo(validateSSSnoInput());
        System.out.print("TIN Number: ");
        employee.setTinNo(validateTINnoInput());
        System.out.print("Pagibig Number: ");
        employee.setPagibigNo(validatePAGIBIGnoInput());
        System.out.print("Employee Number: ");
        employee.setEmployeeNo(validateStringInput());
        return employee;
    }

    private static void updateEmployee() {
        try {
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
                        employee.setDateEmployed(validateTimestampInput());
                        break;
                    case 6:
                        System.out.print("Enter new Birthdate: ");
                        employee.setBirthdate(validateTimestampInput());
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
                        employee.setEmail(validateEmailInput());
                        break;
                    case 15:
                        System.out.print("Enter new SSS Number: ");
                        employee.setSssNo(validateSSSnoInput());
                        break;
                    case 16:
                        System.out.print("Enter new TIN Number: ");
                        employee.setTinNo(validateTINnoInput());
                        break;
                    case 17:
                        System.out.print("Enter new Pagibig Number: ");
                        employee.setPagibigNo(validatePAGIBIGnoInput());
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
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
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

    private static String validateEmailInput() {
        String email;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher;
        do {
            email = scanner.nextLine().trim();
            matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                System.out.print("Invalid email. Please enter a valid email address: ");
            }
        } while (!matcher.matches());
        return email;
    }


    private static String validateSSSnoInput() {
        String sssNo;
        Pattern pattern = Pattern.compile("^(\\d{1}-\\d{1}-\\d{7}-\\d{1})|(\\d{2}-\\d{7}-\\d{1})|(\\d{3}-\\d{6}-\\d{1})$");
        Matcher matcher;
        do {
            sssNo = scanner.nextLine().trim();
            matcher = pattern.matcher(sssNo);
            if (!matcher.matches()) {
                System.out.print("Invalid SSS No. Please enter a valid SSS No in the format X-X-XXXXXXX-X or XX-XXXXXXX-X or XXX-XXXXXX-X: ");
            }
        } while (!matcher.matches());
        return sssNo;
    }

    private static String validateTINnoInput() {
        String tinNo;
        Pattern pattern = Pattern.compile("^\\d{3}-\\d{3}-\\d{3}$|^\\d{3}-\\d{3}-\\d{3}-\\d{3}$");
        Matcher matcher;
        do {
            tinNo = scanner.nextLine().trim();
            matcher = pattern.matcher(tinNo);
            if (!matcher.matches()) {
                System.out.print("Invalid TIN No. Please enter a valid TIN No in the format XXX-XXX-XXX or XXX-XXX-XXX-XXX: ");
            }
        } while (!matcher.matches());
        return tinNo;
    }

    private static String validatePAGIBIGnoInput() {
        String pagibigNo;
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{4}-\\d{4}$");
        Matcher matcher;
        do {
            pagibigNo = scanner.nextLine().trim();
            matcher = pattern.matcher(pagibigNo);
            if (!matcher.matches()) {

                System.out.print("Invalid PAGIBIG No. Please enter a valid PAGIBIG No in the format XXXX-XXXX-XXXX: ");
            }
        } while (!matcher.matches());
        return pagibigNo;
    }

    private static Timestamp validateTimestampInput() {
        Timestamp timestamp = null;
        boolean valid = false;
        do {
            String input = scanner.nextLine().trim();
            try {
                timestamp = Timestamp.valueOf(input);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid timestamp format. Please enter in the format yyyy-mm-dd hh:mm:ss: ");
            }
        } while (!valid);
        return timestamp;
    }
}