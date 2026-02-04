import java.util.*;
public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Chennai");
        System.out.println("Cities List: " + cities);

        cities.add(1,"Hyderabad");
        System.out.println("Cities List after adding Hyderabad at index 1: " + cities);

        cities.remove("Bangalore");
        System.out.println("Cities List after removing Bangalore: " + cities);

        for(String city: cities) {
            System.out.println("City: " + city );
        }

        
        
    }
    
}
