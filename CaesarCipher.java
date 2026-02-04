import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        //String text = "HELLO";
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the text to encrypt: ");
        String text = sc.nextLine();
        //int shift = 1;
        System.out.print("Enter the shift value: ");
        int shift = sc.nextInt();

        StringBuilder encrypt = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'A';
                
                int newChar = (c - base + shift) % 26 + base; 
                encrypt.append((char) newChar);
            } else {
                encrypt.append(c);
            }
        }
        System.out.println("Encrypted Text: " + encrypt.toString());
    }

}
