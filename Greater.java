import java.util.*;
public class Greater {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First number: ");
        int num1=sc.nextInt();
        System.out.println("Enter Second number: ");
        int num2=sc.nextInt();
        System.out.println("Enter Third number: ");
        int num3=sc.nextInt();
        if(num1>=num2){
            if(num1>=num3){
                System.out.println(num1+" is Greater.");
            }
            else{
                System.out.println(num3+" is greater.");
            }
        }else if(num2>=num3){
            System.out.println(num2+" is greater.");
        }
        else{
            System.out.println(num3+" is greater.");
        }

    }
    
}
