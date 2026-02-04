public class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a-b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Sum of 2 integers: " + calc.add(5, 10));
        System.out.println("Sum of 2 doubles: " + calc.add(30.6, 10.0));
        System.out.println("Sum of 3 integers: " + calc.add(5, 10, 15));
        Calculator cal=new Calculator();
        int sum1 = cal.add(10,30);
        System.out.println( sum1);
        double sum2 = cal.add(8.5,6.1);   
        System.out.println( sum2);
        int sum3 = cal.add(22,33,76);
        System.out.println(sum3);
        A a = new A();
        a.display();
        new B().display();   
    }
}
class A{
    void display() {
        System.out.println("Parent class method");
    }
}
class B extends A {
    void display() {
        System.out.println("Child class method");
    }
}

    