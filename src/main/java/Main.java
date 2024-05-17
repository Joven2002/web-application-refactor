import com.system.demo.EmployeeInfoMgtApplication;
import com.system.demo.StudentInfoMgtApplication;

import com.system.demo.UserInfoMgtApplication;
import com.system.demo.appl.facade.employee.EmployeeFacade;
import com.system.demo.appl.facade.student.StudentFacade;
import com.system.demo.appl.facade.user.UserFacade;
import com.system.demo.appl.model.employee.Employee;
import com.system.demo.appl.model.student.Student;
import com.system.demo.appl.model.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static List<String> existingStudentIds = new ArrayList<>();

    public static void main(String[] args) {

        StudentInfoMgtApplication app = new StudentInfoMgtApplication();
        StudentFacade studentFacade = app.getStudentFacade();
        UserInfoMgtApplication user = new UserInfoMgtApplication();
        UserFacade userFacade  = user.getUserFacade();
        EmployeeInfoMgtApplication emp = new EmployeeInfoMgtApplication();
        EmployeeFacade employeeFacade = emp.getEmployeeFacade();

        Scanner sc = new Scanner(System.in);
        displayMenu();
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                viewAllStudents(studentFacade);
                break;
            case 2:
                viewAllUser(userFacade);
                break;
            case 3:
                viewAllEmployees(employeeFacade);
                break;
            case 4:
               addStudent(studentFacade, sc);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private static void displayMenu() {
        System.out.println("----- Student Management System Menu -----");
        System.out.println("1. View All Students");
        System.out.println("2. View All Users");
        System.out.println("3. View All Employee");
        System.out.println("4. Add Students");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void viewAllStudents(StudentFacade studentFacade) {
        System.out.println("Showing all students...");
        List<Student> studentList = studentFacade.getAllStudents();
        for (Student student : studentList) {
            System.out.println("Student ID: " + student.getId() +
                    " | Address: " + student.getAddress() +
                    " | Birthdate: " + student.getBirthdate() +
                    " | Birthplace: " + student.getAddress() +
                    " | Citizenship: " + student.getCitizenship() +
                    " | Civil Status: " + student.getCivil_status() +
                    " | Contact Number: " + student.getContactNumber() +
                    " | Email: " + student.getEmail() +
                    " | First Name: " + student.getFirstName() +
                    " | Last Name: " + student.getLastName() +
                    " | Middle Name: " + student.getMiddleName() +
                    " | Religion: " + student.getReligion() +
                    " | Sex: " + student.getEmail() +
                    " | Student Number: " + student.getStudentNumber() +
                    " | Section ID: " + student.getSectionId());
        }
    }

    private static void viewAllUser(UserFacade userFacade) {
        System.out.println("Showing all user...");
        List<User> userList = userFacade.getAllUsers();
        for (User user : userList) {
            System.out.println("Student ID: " + user.getId() +
                    " | Address: " + user.getUserId() +
                    " | Authorities"+ user.getAuthorities()+
                    " | UserName: " + user.getUsername() +
                    " | PassWord: " + user.getPassword() +
                    " | JoinDate: " + user.getJoinDate() +
                    " | LastLogin: " + user.getLastLoginDate() +
                    " | role: " + user.getRole()+
                    " | Is_Active"+ user.getIsActive()+
                    " | Is_Locked"+ user.getIsLocked());
        }
    }
    private static void viewAllEmployees(EmployeeFacade employeeFacade) {
        System.out.println("Showing all Employees ...");
        try {
            List<Employee> employeeList = employeeFacade.getAllEmployees();

            if (employeeList != null && !employeeList.isEmpty()) {
                for (Employee employee : employeeList) {
                    System.out.println("Employee ID: " + employee.getId());
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

    private static void addStudent(StudentFacade studentFacade, Scanner sc) {
        System.out.println("Adding a new Student...");
        Student newStudent = new Student();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        if (!lastName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Last Name. Please try again.");
            return;
        }
        newStudent.setLastName(lastName);


        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        if (!firstName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid First Name. Please try again.");
            return;
        }
        newStudent.setFirstName(firstName);

        System.out.print("Enter Middle Name: ");
        String middleName = sc.nextLine();
        if (!middleName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Middle Name. Please try again.");
            return;
        }
        newStudent.setMiddleName(middleName);

        System.out.print("Enter Birthday (MM/DD/YYYY): ");
        String birthdate = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date parsedDate = new Date(dateFormat.parse(birthdate).getTime());
            newStudent.setBirthdate(parsedDate);
        } catch (ParseException e) {
            System.out.println("Error parsing birthdate: " + e.getMessage());
            return;
        }


        System.out.print("Enter Birthplace: ");
        String birthplace = sc.nextLine();
        if (!(birthplace != null && !birthplace.isEmpty())) {
            System.out.println("Invalid birthplace format. Please try again.");
            return;
        }
        newStudent.setBirthplace(birthplace);


        System.out.print("Enter Sex: ");
        String sex = sc.nextLine();
        if (!(sex != null && !sex.isEmpty())) {
            System.out.println("Invalid sex format. Please try again.");
            return;
        }
        newStudent.setSex(sex);


        System.out.print("Enter Citizenship: ");
        String citizenship = sc.nextLine();
        if (!(citizenship != null && !citizenship.isEmpty())) {
            System.out.println("Invalid citizenzhip format. Please try again.");
            return;
        }
        newStudent.setCitizenship(citizenship);


        System.out.print("Enter Civil Status : ");
        String civilstatus = sc.nextLine();
        if (!(civilstatus != null && !civilstatus.isEmpty())) {
            System.out.println("Invalid civilstatus format. Please try again.");
            return;
        }
        newStudent.setCivil_status(civilstatus);

        System.out.print("Enter Religion: ");
        String religion = sc.nextLine();
        if (!(religion != null && !religion.isEmpty())) {
            System.out.println("Invalid religion format. Please try again.");
            return;
        }
        newStudent.setAddress(religion);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please try again.");
            return;
        }
        newStudent.setEmail(email);

        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        if (!(address != null && !address.isEmpty())) {
            System.out.println("Invalid address format. Please try again.");
            return;
        }
        newStudent.setAddress(address);


        System.out.print("Enter Contact Number: ");
        String contactNumber = sc.nextLine();
        if (!isValidContactNumber(contactNumber)) {
            System.out.println("Invalid contact number format. Please try again.");
            return;
        }
        newStudent.setContactNumber(contactNumber);

        System.out.print("Enter Student ID: ");
        String studentNumber = sc.nextLine();
        if (!isValidStudentId(studentNumber)) {
            System.out.println("Invalid Student ID. Please try again.");
            return;
        }
        newStudent.setStudentNumber(studentNumber);


        System.out.print("Enter Section ID: ");
        int sectionId = sc.nextInt();
        sc.nextLine();
        newStudent.setSectionId(sectionId);

        try {
            studentFacade.addStudent(newStudent);
            System.out.println("Student successfully added.");
        } catch (Exception e) {
            System.out.println("Error in adding student: " + e.getMessage());
        }
    }

    private static void updateStudentById(StudentFacade studentFacade, Scanner sc) {
        System.out.println("Updating Student...");
        System.out.print("Enter Student ID to update: ");
        String studentId = sc.nextLine();
        sc.nextLine();
        Student studentToUpdate = studentFacade.getStudentById(studentId);
        if (studentToUpdate == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        if (!lastName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Last Name. Please try again.");
            return;
        }
        studentToUpdate.setLastName(lastName);


        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        if (!firstName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid First Name. Please try again.");
            return;
        }
        studentToUpdate.setFirstName(firstName);

        System.out.print("Enter Middle Name: ");
        String middleName = sc.nextLine();
        if (!middleName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Middle Name. Please try again.");
            return;
        }
        studentToUpdate.setMiddleName(middleName);

        System.out.print("Enter Birthday (MM/DD/YYYY): ");
        String birthdate = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date parsedDate = new Date(dateFormat.parse(birthdate).getTime());
            studentToUpdate.setBirthdate(parsedDate);
        } catch (ParseException e) {
            System.out.println("Error parsing birthdate: " + e.getMessage());
            return;
        }


        System.out.print("Enter Birthplace: ");
        String birthplace = sc.nextLine();
        if (!(birthplace != null && !birthplace.isEmpty())) {
            System.out.println("Invalid birthplace format. Please try again.");
            return;
        }
        studentToUpdate.setBirthplace(birthplace);


        System.out.print("Enter Sex: ");
        String sex = sc.nextLine();
        if (!(sex != null && !sex.isEmpty())) {
            System.out.println("Invalid sex format. Please try again.");
            return;
        }
        studentToUpdate.setSex(sex);


        System.out.print("Enter Citizenship: ");
        String citizenship = sc.nextLine();
        if (!(citizenship != null && !citizenship.isEmpty())) {
            System.out.println("Invalid citizenzhip format. Please try again.");
            return;
        }
        studentToUpdate.setCitizenship(citizenship);


        System.out.print("Enter Civil Status : ");
        String civilstatus = sc.nextLine();
        if (!(civilstatus != null && !civilstatus.isEmpty())) {
            System.out.println("Invalid civilstatus format. Please try again.");
            return;
        }
        studentToUpdate.setCivil_status(civilstatus);

        System.out.print("Enter Religion: ");
        String religion = sc.nextLine();
        if (!(religion != null && !religion.isEmpty())) {
            System.out.println("Invalid religion format. Please try again.");
            return;
        }
        studentToUpdate.setAddress(religion);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please try again.");
            return;
        }
        studentToUpdate.setEmail(email);

        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        if (!(address != null && !address.isEmpty())) {
            System.out.println("Invalid address format. Please try again.");
            return;
        }
        studentToUpdate.setAddress(address);


        System.out.print("Enter Contact Number: ");
        String contactNumber = sc.nextLine();
        if (!isValidContactNumber(contactNumber)) {
            System.out.println("Invalid contact number format. Please try again.");
            return;
        }
        studentToUpdate.setContactNumber(contactNumber);

        System.out.print("Enter Student ID: ");
        String studentNumber = sc.nextLine();
        if (!isValidStudentId(studentNumber)) {
            System.out.println("Invalid Student ID. Please try again.");
            return;
        }
        studentToUpdate.setStudentNumber(studentNumber);


        System.out.print("Enter Section ID: ");
        int sectionId = sc.nextInt();
        sc.nextLine();
        studentToUpdate.setSectionId(sectionId);

        try {
            studentFacade.updateStudent(studentToUpdate);
            System.out.println("Student successfully updated.");
        } catch (Exception e) {
            System.out.println("Error in updating student: " + e.getMessage());
        }
    }
    public static boolean isValidStudentId(String studentId) {
        String pattern = "CT\\d{2}-\\d{4}";
        if (studentId.matches(pattern)) {
            return true; // Return true if the ID matches the pattern
        } else {
            System.out.println("Invalid student ID format.");
            return false;
        }
    }


    /**
     * Validation for Birthday it should have this pattern MM/DD/YYYY.
     */
    public static boolean isValidBirthday(String birthday) {
        String[] parts = birthday.split("/");
        if (parts.length != 3)
            return false;

        int month, day, year;
        try {
            month = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        if (month < 1 || month > 12)
            return false;

        if (day < 1 || day > 31)
            return false;

        if (year < 1950 || year > 2100)
            return false;

        return true;
    }


    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * Validation for contact number it should be a number only.
     */
    public static boolean isValidContactNumber(String contactNumber) {
        String contactNumberRegex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(contactNumberRegex);
        Matcher matcher = pattern.matcher(contactNumber);
        return matcher.matches();
    }


}
