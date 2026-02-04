import java.util.*;
public class LinkesdHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>(); // Ordered 
        lhs.add("Mumbai");
        lhs.add("Kolkata");
        lhs.add("Delhi");
        lhs.add("Bangalore");
        lhs.add("Patna");
        lhs.add("Mumbai"); // Duplicate element,this will not be added.
        lhs.add("Noida");
        lhs.add("Goa");

        LinkedHashSet<Integer> lhs2 = new LinkedHashSet<>();
        lhs2.add(1);
        lhs2.add(10);
        lhs2.add(10);

        Iterator<Integer> element2 = lhs2.iterator();
        while (element2.hasNext())
        {
            System.out.println(element2.next());
        }


        Iterator<String> element = lhs.iterator();
        while (element.hasNext()) 
        {
            System.out.println(element.next());
        }
    }
    
}
