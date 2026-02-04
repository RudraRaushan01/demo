public class MultipleIn {
    public static void main(String[] args) {
        D d = new D();
        d.methodA();
        d.methodB();
        d.methodC();
    }
}
interface A {
    void methodA();
}
interface B {
    void methodB();
}
interface C extends A,B {
    void methodC();  
}
class D implements C {
    public void methodA() {
        System.out.println("Method A from interface A");
    }
    public void methodB() {
        System.out.println("Method B from interface B");
    }
    public void methodC() {
        System.out.println("Method C from interface C");
    }
}


