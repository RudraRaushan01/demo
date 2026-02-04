public class MaxArr{
    public static void main(String[] args) {
       
        int[] arr=new int[5];
        arr[0]=12;
        arr[1]=23;
        arr[2]=45;
        arr[3]=87;
        arr[4]=68;
         int max=arr[0];
         int min=arr[0];
         for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }  
         }
          System.out.println("Maximun value: "+max);
          for(int j=0;j<arr.length;j++){
            if(arr[j]<min){
                min=arr[j];
            }
          }
          System.out.println("Minimum value: "+min);
    }   
}
