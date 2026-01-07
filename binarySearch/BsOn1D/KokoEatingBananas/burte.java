public class random {
  
    static boolean ans(int[] arr, int n,int h){
        int hours = 0;
        for(int i = 0; i< arr.length;i++){
            hours = hours +(arr[i] + n - 1) / n;
        }
        return hours <= h;
    }


    static int minEatingSpeed(int[] arr, int h) {

       int max =  Integer.MIN_VALUE;
       for(int i = 0; i< arr.length;i++){
           max = Math.max(arr[i],max);
       }

       for(int i = 1;i<= max ;i++){

           if(ans(arr,i,h)) return i;
       }


        return -1;
    }

    public static void main(String[] args) {
       int[] arr = {3,6,7,11};
       int h = 8;
        System.out.println(minEatingSpeed(arr,h));
    }
}
