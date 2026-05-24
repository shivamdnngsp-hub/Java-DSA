class Solution {

   public int findSmallest(int[][] arr){
    int smallest = Integer.MAX_VALUE;
    for(int i = 0; i< arr.length;i++){
        if(arr[i][0] < smallest){
            smallest = arr[i][0];
        }
    }
    return smallest;
   }

   public int findLarget (int[][] arr){
    int largest = Integer.MIN_VALUE;
    for(int i = 0; i< arr.length;i++){
        if(arr[i][arr[0].length-1] > largest){
            largest = arr[i][arr[0].length-1];
        }
    }
    return largest;
   }
    
    public int occuranceLessThanEqualToMid(int[][] arr,int mid){
        int count = 0;
        for(int i = 0; i<arr.length;i++){
           int upparBoundOfMid = upparBound(arr,i, mid);
            count += upparBoundOfMid;
        }
     return count;
    }


  public int upparBound(int[][] arr, int i,int target){
   int index = arr[i].length;
   int low = 0;
   int high = arr[i].length-1;
   while(low <= high){
    int mid = low + (high-low)/2;
    if(arr[i][mid] > target){
        index = mid;
        high = mid -1;
    }else{
        low = mid +1;
    }
   }
return index;
  }
  


    public int findMedian(int[][] arr) {
    int smallest = findSmallest(arr);
    int largest = findLarget (arr);
    int low = smallest;
    int high = largest;
    int ans = -1;
    while(low <=high){
        int mid = low + (high -low)/2;
        int occurance = occuranceLessThanEqualToMid(arr,mid);
         if(occurance > (arr.length * arr[0].length)/2){
           ans = mid;
           high = mid-1;
         }else{
            low = mid + 1;
         }

    }

return ans;

    }
}
