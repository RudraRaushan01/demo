import java.util.Scanner;
public class PaintWall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Interior:");
        int height = sc.nextInt();
        System.out.println("Enter the Number of Exterior:");
        int width = sc.nextInt();

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print("*");
            
        int area1 = sc.nextInt();
        System.out.println("Enter the Surface area of interior:");
        int area2 = sc.nextInt();
        System.out.println("Enter the Surface area of exterior:");

    }
}
        
        int totalArea = (height * width) + area1 + area2;
        System.out.println("Total area to be painted: " + totalArea);

    }
    
}
