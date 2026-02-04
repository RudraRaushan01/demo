public class ThrowExam {
    public static void main(String[] args) {
        int age=15;
        if(age<=18) {
            throw new ArithmeticException("Age is less than 18");
        } else {
            System.out.println("You are eligible to vote");
        }
    }
    
}
