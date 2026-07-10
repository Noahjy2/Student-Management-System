import java.util.ArrayList;

public class StudentManager{

    private ArrayList<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }
    


    public Student findStudent(String id){

        for (Student student : students){
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }


     public void addStudent(String id, String name, int age, double cgpa){
        
        Student student = findStudent(id);
        
        if (student != null){
            System.out.println("Student already exist.");
            return;
        } 

        Student newStudent = new Student(id, name, age, cgpa);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }


    public void removeStudent(String id){

        Student student = findStudent(id);

        if (student != null){
            students.remove(student);
        } else {
            System.out.println("Student is not found.");
        }
    }


    public void updateStudent(String id, String option, String newValue){

        Student student = findStudent(id);

        if (student != null){
            switch (option){
                case "id" -> student.setId(newValue);
                case "name" -> student.setName(newValue);
                case "age" -> student.setAge(Integer.parseInt(newValue));
                case "cgpa" -> student.setCgpa(Double.parseDouble(newValue));
                default -> System.out.println("Invalid option");
            }
            System.out.println("Student updated successfully.");
            return;
        }

        System.out.println("Student is not found.");
    }


    public void displayAllStudent(){ 
        if (students.isEmpty()){
            System.out.println("No student found.");
            return;
        }

        System.out.print("""
                ===================================================
                ID        Name                    Age    CGPA 
                ===================================================
                """);
        for (Student student : students){
            System.out.printf("%-8s %-24s %-7d %-6.2f\n",student.getId(),student.getName(),student.getAge(), student.getCgpa());
        }
    }
}