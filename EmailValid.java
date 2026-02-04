
// import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class EmailValid {
    public static void main(String[] args) {
        String email = "1234neet123@gmail.com";
        String regex= "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
    Pattern pattern = Pattern.compile(regex);
    boolean matcher = pattern.matcher(email).matches();
    System.out.println("is valid email: " + matcher);
    }
    
}
