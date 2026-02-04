public class Inherit2 {
    public static void main(String[] args) {     
        Calculate c=new Calculate();
        c.sum(98,76);
        c.sub(45,6);
        multiply m1=new multiply();
        m1.sum(76,565,99);  
        m1.mul(6,5,3);
    }   
}
class Calculate{
    void sum(int a,int b){
        int Sum=a+b;
        System.out.println(Sum);
    }
    void sub(int a, int b){
        int Sub=a-b;
        System.out.println(""+Sub);
    }
}
class multiply extends Calculate{
    void  sum(int a,int b,int c){
        int S=a+b+c;
        System.out.println("Sum of three numbers: "+S);
    }
    void mul(int x,int y ,int z){
        int Mul=z*y*z;
        System.out.println("Multiply of three numbers"+Mul);
    }
}
