
import java.util.Arrays;

public class Darray {
    public static void main(String[] args) {
        int[][] arr={
            {2,3,4},
            {4,5,6}
        };
        System.out.println(arr[1][2]);
        System.out.println(Arrays.toString(arr[0]));
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[j] + ",");
            }
            System.out.println();
        }
    }
    
}
