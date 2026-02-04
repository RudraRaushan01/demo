public class Poly {
    

    public static void main(String[] args) {
        Parent p=new Child();
        p.role();
        p.role();
        Husband h=new Husband();
        h.role();
        Employee e=new Employee();
        e.role();
    }
}
class Parent{
    void role(){
        System.out.println("Parent role");
    }
}
class Child extends Parent{
    void role(){
    
        System.out.println("Child role from parent");
    }
}
class Husband{
    void role(){
        System.out.println("Husband role");
    }
}
class Employee extends Husband{
    void role(){
        System.out.println("Employee role");
    }
}

