import java.util.*;
public class Basic{
    public static void main(String[] args){
        // Create a new Scanner object
        Scanner scanner = new Scanner(System.in);
        System.err.println("Enter first number: ");
        int num1=scanner.nextInt();
        System.out.println("Enter Second number: ");
        int num2=scanner.nextInt();
        int result=num1+num2;
        System.out.println("Addition of "+num1+" and "+num2+" is "+result);


    }
}