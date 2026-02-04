public class Student1 {
    private String name;
    private int rollNo;
    private int marks;
    public Student1(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }
        public void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        if (marks >= 1 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Marks must be between 1 and 100.");
        }
    }
    public static void main(String[] args) {
            Student1 student = new Student1("John", 101, 85);
            Student1 student2 = new Student1("Smith", 102, 95);
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("2nd Student Details:");
            System.out.println("Name: " + student2.getName());
            System.out.println("Roll No: " + student2.getRollNo());
            System.out.println("Marks: " + student2.getMarks());
            student.setMarks(100); 

       
        
    }
}
