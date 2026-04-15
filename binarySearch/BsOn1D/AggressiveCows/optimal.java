import java.util.*;

class Solution {

    public boolean canBePlaced(int[] arr, int min, int k) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= min) {
                count++;
                last = arr[i];
            }
        }

        return count >= k;
    }

    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);

    int low = 1;
    int high = arr[arr.length-1] - arr[0];
    int ans = arr[arr.length-1] - arr[0];
    while(low<= high){
        int mid = low + (high-low)/2;
        if(canBePlaced(arr,mid,k)){
            ans = mid;
            low  = mid+1;
        }else{
           high = mid - 1;
        }

    }

return ans;

    }
}
