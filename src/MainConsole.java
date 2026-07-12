import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        //Test
        manager.addStudent("000001", "Alisa Cha", 19, 3.1288);
        manager.addStudent("000002", "Bobby Tan", 21, 2.9223);


        System.out.print("""
        =============================
          STUDENT MANAGEMENT SYSTEM
        =============================
        """);

        //loop the main menu if choice not equal to 
        while (true) {
            System.out.print("""

            1. Display All Student Information
            2. Search Student
            3. Add Student
            4. Remove Student
            5. Update Student
            6. Exit
            """);
            System.out.print("Enter your choice (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> manager.displayAllStudent();
                case "2" -> searchStudent(manager, scanner);
                case "3" -> addNewStudent(manager, scanner);
                case "4" -> deleteStudent(manager, scanner);
                case "5" -> updateStudentInformation(manager, scanner);
                case "6" -> System.out.println("Thanks for using the system");
                default -> System.out.println("Invalid choice!");
            }

            if (choice.equals("6")){
                break;
            }
        }
        
        scanner.close();
    }

    public static void searchStudent(StudentManager manager, Scanner scanner){
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        Student student = manager.findStudent(id);

        if (student != null) {
            System.out.println(student.toString());
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public static void addNewStudent(StudentManager manager, Scanner scanner){
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        Student checkStudent = manager.findStudent(id);
        if (checkStudent != null){
            System.out.println("Student already exist.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        
        manager.addStudent(id, name, age, cgpa);
    }

    public static void deleteStudent(StudentManager manager, Scanner scanner){
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();

        manager.removeStudent(id);
    }

    public static void updateStudentInformation(StudentManager manager, Scanner scanner){
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        Student checkStudent = manager.findStudent(id);
        if (checkStudent == null){
            System.out.println("Student not Found.");
            return;
        }

        System.out.print("""
        1. ID
        2. Name
        3. Age
        4. CGPA
        5. Back to Main Menu
        """);
        System.out.print("Enter field to change (1-5): ");
        String choice = scanner.nextLine();

        if (choice.equals("5")){
            return;
        }

        String option = "";
        switch (choice){
            case "1" -> option = "id";
            case "2" -> option = "name";
            case "3" -> option = "age";
            case "4" -> option = "cgpa";
        }

        System.out.printf("Enter new value for %s : ", option);
        String newValue = scanner.nextLine();
        
        manager.updateStudent(id, option, newValue);
    }
}