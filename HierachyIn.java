public class HierachyIn {
    public static void main(String[] args) {
        First f1 = new First();
        f1.Sum(10, 20);
        f1.Sub(30, 15);

        Second s1 = new Second();
        s1.Mul(5, 6);
        s1.Div(20, 4);

        Third t1 = new Third();
        t1.Mod(10, 3);
    }
}
class First{
    void Sum(int a, int b){
        int sum=a+b;
        System.out.println("Sum is "+sum);
    }
    void Sub(int a, int b){
        int sub=a-b;
        System.out.println("Subtraction is "+sub);
    }
}
class Second extends First{
    void Mul(int a, int b){
        int mul=a*b;
        System.out.println("Multiplication is "+mul);
    }
    void Div(int a, int b){
        if(b!=0){
            int div=a/b;
            System.out.println("Division is "+div);
        }
        else{
            System.out.println("Division by zero is not allowed.");
        }
    }
}
class Third extends Second{
    void Mod(int a, int b){
        if(b!=0){
            int mod=a%b;
            System.out.println("Modulus is "+mod);
        }
        else{
            System.out.println("Modulus by zero is not allowed.");
        }
    }
}
