import java.util.*;
public class Arra {
    public static void main(String[] args) {
        int sum=0;
        int[] arr=new int[5];
        arr[0]=45;
        arr[1]=34;
        arr[4]=87;
        arr[2]=76;
        arr[3]=78;
        System.out.println("ACcessing index 3 and 4 values: "+arr[3]+","+""+arr[4]);

        int[]arr2={10,20,30,40};
        System.out.println("diff. Accessing index 2 value:"+arr2[3]);

        System.out.println("Accessing convert String: "+Arrays.toString(arr2));
         System.out.println("Accessing from for loop: ");
        for(int i=0;i<4;i++){
            System.out.println(arr2[i]);   
        }

        System.out.println("From length of an array: ");
            for (int j=0;j<arr2.length;j++){
                System.out.println(arr[j]);
                sum=sum+arr2[j]; 
            }
            System.out.println("Sum of an Array: "+sum);
    }
    
}
