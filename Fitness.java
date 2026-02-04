import java.util.Scanner;
public class Fitness {
    public static void main(String[] args) {
        int trainee=0;
        int avg=0;
        for(int i=0;i<3;i++){
            System.out.println("Round: "+i+1);
            for(int j=0;j<3;j++){
                
            
            Scanner sc=new Scanner (System.in);
            System.out.print("Enter the Oxygen Level of Trainee " + (j+1) + ": ");
            int Trainee=sc.nextInt();
        }
    }
            trainee+=trainee;
            avg=trainee/3;
            System.out.println("Average Oxygen Level of Trainees: " + avg);
            if(avg<90){
                System.out.println("Trainees are not fit.");
            }
            else{
                System.out.println("Trainees are fit.");
            }
        
        System.out.println("Total Oxygen Level of all Trainees: " + trainee);
        System.out.println("Average Oxygen Level of all Trainees: " + avg);
        }

}
