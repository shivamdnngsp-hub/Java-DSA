

public class random {

static  long totalTime(int[] arr,int x){
    long totalTime = 0;
    for(int i = 0;i< arr.length;i++){
        totalTime += (arr[i] + x - 1) / x;
    }
    return totalTime;
}


    static int minEatingSpeed(int[] arr, int h) {

        int max = Integer.MIN_VALUE;
        for(int i = 0;i< arr.length;i++){
            max = Integer.max(max,arr[i]);
        }
        int low = 1;
        int high = max;
        int ans = max;
        while(low<=high){

            int mid = (low+high)/2;
            long totaltime = totalTime(arr,mid);
            if(totaltime<=h){
                ans = Math.min(ans,mid);
                high = mid-1;
            }
           else {
               low = mid+1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(arr, h));
    }
}
