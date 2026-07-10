public class Student {
    private String id;
    private String name;
    private int age;
    private double cgpa;

    public Student(String id, String name, int age, double cgpa){
        this.id = id;
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.age + " " + this.cgpa;
    }

    //Getter
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public double getCgpa(){
        return this.cgpa;
    }

    //Setter
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCgpa(double cgpa){
        this.cgpa = cgpa;
    }

}