public class Palin {
    public static void main(String[] args) {
        int rev=0,rem;
        int n=123454321;
        int num=n;
        while(num!=0){
            rem=num%10;
            rev=rev*10+rem;
            num=num/10;
        }
        if(n==rev){
            System.out.println("Palindrome: "+n);
        }
        else{
            System.out.println("Not"+n);
        }
    }
    
}
