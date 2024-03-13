import com.employee.information.management.app.facade.employee.EmployeeFacade;
import com.employee.information.management.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;

import java.util.Scanner;

public class Main {
    //update employee
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacadeImpl(new EmployeeDaoImpl());
        Scanner scanner = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("1. Update Employee");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        String employeeNo = "0";
                        do {
                            System.out.print("Search Employee No.: ");
                            employeeNo = scanner.next();

                            System.out.println("Update lastname: ");
                            String lastName = scanner.next();

                            System.out.println("Update firstname: ");
                            String firstName = scanner.next();

                            System.out.println("Update middlename: ");
                            String middleName = scanner.next();

                            System.out.println("Update position in RC: ");
                            String posInRc = scanner.next();

                            System.out.println("Update date employed");
                            String dateEmployed = scanner.next();

                            System.out.println("Update birthdate");
                            String birthDate = scanner.next();

                            System.out.println("Update birthplace");
                            String birthPlace = scanner.next();

                            System.out.println("Update sex");
                            String sex = scanner.next();

                            System.out.println("Update civil status");
                            String civilStatus = scanner.next();

                            System.out.println("Update citizenship");
                            String citizenship = scanner.next();

                            System.out.println("Update religion");
                            String religion = scanner.next();

                            System.out.println("Update height");
                            double height = scanner.nextDouble();

                            System.out.println("Update weight");
                            double weight = scanner.nextDouble();

                            System.out.println("Update email");
                            String email = scanner.next();

                            System.out.println("Update SSS NO");
                            String sss = scanner.next();

                            System.out.println("Update TIN NO");
                            String tin = scanner.next();

                            System.out.println("Update PAGIBIG NO");
                            String pagibig = scanner.next();

                            Employee existingEmployee = employeeFacade.getEmployeeByNo(employeeNo);
                            if (existingEmployee != null) {
                                existingEmployee.setLastName(lastName);
                                existingEmployee.setFirstName(firstName);
                                existingEmployee.setMiddleName(middleName);
                                existingEmployee.setPositionInRC(posInRc);
                                existingEmployee.setDateEmployed(dateEmployed);
                                existingEmployee.setBirthDate(birthDate);
                                existingEmployee.setBirthPlace(birthPlace);
                                existingEmployee.setSex(sex);
                                existingEmployee.setCivilStatus(civilStatus);
                                existingEmployee.setCitizenship(citizenship);
                                existingEmployee.setReligion(religion);
                                existingEmployee.setHeight(height);
                                existingEmployee.setWeight(weight);
                                existingEmployee.setEmail(email);
                                existingEmployee.setSssNo(sss);
                                existingEmployee.setTinNo(tin);
                                existingEmployee.setPagibigNo(pagibig);

                                boolean updated = employeeFacade.updateEmployee(existingEmployee);
                                if (updated) {
                                    System.out.println("Employee updated successfully!");
                                } else {
                                    System.out.println("Failed to update employee.");
                                }
                            } else {
                                System.out.println("employee with No " + employeeNo + " does not exist.");
                            }
                        } while (employeeNo.equals(0));
                        break;
                    case 0:
                        System.out.println("Quitting the App...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

