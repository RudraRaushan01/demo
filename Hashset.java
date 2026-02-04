import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(); // Unordered collection
        set.add("NIET");
        set.add("College");
        set.add("For");
        set.add("Technical");
        set.add("Education");
        set.add("NIET"); // Duplicate element,this will not be added.
        set.add("Noida");
        set.add("India");


        Iterator<String> element = set.iterator();
        while (element.hasNext()) 
        {
            System.out.println(element.next());
        }
    }
    
}
