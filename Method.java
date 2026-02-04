public class Method {
     void Greater(int a,int b){
        if(a>b){
            System.out.println(a+" is greater.");
        }
        else{
            System.out.println(b+" is greater.");
        }

    }
    
    public static void main(String[] args) {
        
        Method m1 = new Method();
        m1.Greater(10, 20);
        m1.Greater(30, 15);
        m1.Greater(25, 25);


        
    }
    
}
