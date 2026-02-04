
import java.util.ArrayList;
import java.util.List;

public class WrapperPrac {
    public static void main(String[] args) {
        // Autoboxing Example:
        int a=50;
        Integer A=a;
        System.out.println("Autoboxing: = " + A);
        // Unboxing Example:
        Integer B=new Integer(100);
        int b=B; 
        System.out.println("Unboxing: = " + b);

        Integer sum=A+B; // Autoboxing
        System.out.println("Sum of A and B: " + sum);

        List<Integer> numbers=new ArrayList<>();
        numbers.add(10); // Autoboxing int to Integer
        numbers.add(20);
        numbers.add(30);
        for(int num: numbers) {
            System.out.println("Number: " + num); // Unboxing Integer to int
        }

    }
    
}
