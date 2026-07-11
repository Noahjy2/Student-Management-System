import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        //Test
        manager.addStudent("000001", "Alisa Cha", 19, 3.12);
        manager.addStudent("000002", "Bobby Tan", 21, 2.92);


        System.out.println("""
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
                case "4" -> System.out.println("Remove student by ID");
                case "5" -> System.out.println("Update Student information by ID");
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
}