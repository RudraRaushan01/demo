import java.util.*;
public class ArrayOperation {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Pineapple");
        fruits.add("Cherry");
        fruits.add("Date");
        System.out.println("Fruits List: " + fruits);
        System.out.println("Element at 2 index " +fruits.get(2));

        fruits.set(1, "Orange");
        System.out.println("Updated Fruits List: " + fruits);

        fruits.add(2, "Kiwi");
        System.out.println("Fruits List after adding index 2: " + fruits);
        fruits.remove(3);
        System.out.println("Fruits List after removing index 3: " + fruits);
        fruits.remove("Mango");
        System.out.println("Fruits List after removing Mango: " + fruits);

        System.out.println("Contains Cherry? " + fruits.contains("Cherry"));

        System.out.println("Size of the Fruits List: " + fruits.size());

        System.out.println("Is the Fruits List empty? " + fruits.isEmpty());

        Collections.sort(fruits);
        System.out.println("Sorted Fruits List: " + fruits);

        Collections.reverse(fruits);
        System.out.println("Reversed Fruits List: " + fruits);
        Collections.shuffle(fruits);
        System.out.println("Shuffled Fruits List: " + fruits);

        


        System.out.println("Iterating using the iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

