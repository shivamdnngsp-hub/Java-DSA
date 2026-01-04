public class random {
    static int squareRoot(int x) {

     int low = 1;
     int high = x;
     int ans = 1;
     while(low<= high){
         int mid = low + (high-low)/2;
         if((mid)*(mid) == x) {
             return mid;
         }
         else if((mid)*(mid) > x){
             high = mid-1;
         }
         else if((mid)*(mid)<x){
             ans = mid;
             low = mid +1;
         }
     }

        return ans;
    }

    public static void main(String[] args) {
       int x = 28;
        System.out.println(squareRoot((x)));
    }
}
