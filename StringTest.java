public class StringTest {
    public static void main(String[] args) {
         String str="Hello String";
        System.err.println("String Name: "+str);
        int length=str.length();
        System.out.println("Length of String: "+length);
        char ch=str.charAt(7);
        System.out.println("7th Value of String: "+ch);
        int indf=str.indexOf("S");
        System.out.println("Index of 'S': "+indf);
        int lastind=str.lastIndexOf("i");
        System.out.println("Last Index of 'i': "+lastind);
        String str1=str.toUpperCase();
        System.out.println("Uppercase String: "+str1);
        String str2=str.toLowerCase();
        System.out.println("Lowercase String: "+str2);
        String replace=str.replace("e","i");
        System.out.println("Replaced String: "+replace);
        String s="Ravi "+str;
        System.out.println(s);

        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
        }

        // String ss=new String("Hello World");
        // String sss=new String("Hello World");
        // System.out.println("SS and SSS "+ss+" "+sss);


    }
    
}