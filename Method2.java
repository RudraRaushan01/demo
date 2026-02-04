

public class Method2 {
    
    public static void main(String[] args) {
        Method m1=new Method();
        m1.add(3,8);
        
    }
    
}
class Method{
    void add(int a,int b){
        int sum=a+b;
        System.out.println(sum);
    }
}