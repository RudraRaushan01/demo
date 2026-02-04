import java.util.*;

public class HashPara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String para = sc.nextLine();

        String[] words = para.toLowerCase().split(" ");

        Set<String> uniqueWords = new HashSet<>();

        for(int i=0;i<words.length;i++) {
                uniqueWords.add(words[i]);
        }


        
        Iterator<String> element = uniqueWords.iterator();
        System.out.println("\nUnique words used in the paragraph:");
        while (element.hasNext()) {
            System.out.println(element.next());
        }
    }
}
