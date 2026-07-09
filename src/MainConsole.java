import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

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
                case "1" -> System.out.println("Display all student information");
                case "2" -> System.out.println("Search student by ID");
                case "3" -> System.out.println("Add student");
                case "4" -> System.out.println("Remove student by ID");
                case "5" -> System.out.println("Update Student information by ID");
                case "6" -> System.out.println("Thanks for using the system");
                default -> System.out.println("Invalid choice!");
            }

            if (!choice.equals("6")){
                break;
            }
        }
        
        scanner.close();
    }
}