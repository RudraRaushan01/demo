public class Boxing {
    public static void main(String[] args) {
        //Autoboxing  example
        int x=100;
        Integer y=x; // Autoboxing
        System.out.println("Autoboxed integer: " + y);

        //Unboxing example
        Integer z = new Integer(200);
        int w = z; // Unboxing
        System.out.println("Unboxed integer: " + w);
    }
    
}
