public class StringBuild {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Welcome");
        System.out.println("Original String: " + sb);
       
        sb.append(" to java.");
        System.out.println("Final String: " + sb);
        sb.reverse();
        System.out.println("Reversed String: " + sb);
        
        // sb.insert(5, " Beautiful");
        // System.out.println("After Insertion: " + sb);
    
    }
}
