import java.util.*;
public class TreeMapP1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> m = new TreeMap<>();
        m.put(10, "Shweta");
        m.put(20, "Amiya");
        
        m.put(30, "Ankita");
        m.put(40, "Pushp");
        m.put(50, "Ritik");
        m.put(60, "Shivam");
        m.put(70, "Rahul");

        for(Map.Entry<Integer, String> e : m.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("TreeMap: " + m);
    }
    
}
