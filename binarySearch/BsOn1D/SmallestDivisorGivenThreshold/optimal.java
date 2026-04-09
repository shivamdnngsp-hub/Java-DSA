class Solution {

  public int  sum(int[] nums, int x){
    int sum = 0;
    for(int i = 0; i< nums.length;i++){
      sum += (nums[i] + x-1)/x;
    }
    return sum;
  }



    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
      
      int low = 1;
      int high = max;
      int ans = max;
      while(low<= high){
       int mid = low + (high - low)/2;
       int sum = sum(nums,mid);
      if(sum<= threshold){
        ans = mid;
        high = mid -1;
      }else{
        low = mid + 1;
      }

      }


return ans;

    }
}
