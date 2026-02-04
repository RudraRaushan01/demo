public class Except {
    public static void main(String[] args) {
       try {
        int a=10/0;
        } catch (ArithmeticException e) {
        System.out.println("Arithmetic Error");
       }
       try{
        int[] arr=new int[2];
        arr[2]=10;
        
        System.out.println("Result: " + arr[2]);
       }  
       catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Array index out of bounds: ");
       }
       catch (NullPointerException e) {
        System.out.println("Null pointer exception: ");
       }
       catch (NumberFormatException e) {
        System.out.println("Number format exception: ");
       }
       


       finally {
        System.out.println("Finally block executed");
       }
    }

    
}
