import java.util.*;
public class WashingMachine {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter weight for wash clothes: ");
        int weight=0;
        try{
            weight=sc.nextInt();
        if(weight>0 && weight<=7000){
            if(weight>0 && weight<=2000){
                System.out.println("25 Minutes.");
            }else if(weight>2000 && weight<=4000){
                System.out.println("35 Minutes.");
            }else{
                System.out.println("45 Minutes.");
            }
        }else if(weight==0){
            System.out.println("Zero Minutes.");
        }else if(weight<0){
            System.out.println("Invalid Weight");
            
        }else{
            System.out.println("Over Weight");
        }
    }catch(Exception e){
        System.out.println("Invalid Input"+e.getMessage());
    }finally{
        System.out.println("Thank you for using the Washing Machine.");
    }
    }
    
}
