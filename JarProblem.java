import java.util.Scanner;
public class JarProblem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Candies:");
        int Total=sc.nextInt();
        System.out.println("Enter the number of candies you want to buy: ");
        int candies=sc.nextInt();
        System.out.println("Number of candies sold: " + candies);

        int Remaining =0;
        Remaining = Total-candies;
        System.out.println("Number of candies Available: " + Remaining);
        if(Remaining<(Total/2)){
            Remaining+=candies;
            System.out.println("Candies filled in the jar: " + Remaining);
            
        }
        else{
            System.out.println("Nothing to fill in the jar.");
        }


        
    }
    
}

