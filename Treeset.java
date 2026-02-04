import java.util.*;
public class Treeset {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(); // Sorted collection
        // set.add("NIET");
        // set.add("College");
        // set.add("For");
        // set.add("Technical");
        // set.add("Education");
        // set.add("NIET"); // Duplicate element,this will not be added.
        // set.add("123Delhi");
        // set.add("agra");

        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter the number to insert: ");
        // int n=sc.nextInt();
        int n=5;
        

         System.out.println("Enter "+n+" elements:");

         for(int i=0;i<n;i++)
         {
            int num=sc.nextInt();
             set.add(num);
         }
        System.out.println("Enter "+n+" elements:");


        Iterator<Integer> element = set.iterator();
        while (element.hasNext()) 
        {
            System.out.println(element.next());
        }
    }
    
}
