import java.util.*;
public class ArrayList {
    public static void main(String[] args) {
        List<String> name = new java.util.ArrayList<>();
        
        name.add("Hello");
        name.add("World");
        name.add("Java");
        name.add("Programming");
        System.out.println("List: " + name);
        System.out.println("Size of the List: " + name.size());

        List<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("List: " + numbers);
        System.out.println("Size of the numbers: " + numbers.size());
        numbers.remove(1);
        numbers.get(0);
        System.out.println("List after removing an element: " + numbers);
        numbers.set(1, 10);
        System.out.println("List after setting an element: " + numbers);
    }
    
}
