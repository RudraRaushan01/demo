public class Student {
    public static void main(String[] args) {
        Student1 s1=new Student1("Ram",191);
        s1.display();
    }

    Student(String alice, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
class Student1{
    String name;
    int roll;
    static String college="ABCD institute";
    Student1(String n,int r){
        name=n;
        roll=r;
    }
    void display(){
        System.out.println(name);
        System.out.println(roll);
        System.out.println(college);
    }
}
