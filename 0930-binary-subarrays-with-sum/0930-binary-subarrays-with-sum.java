class Solution {

    public int slidingWindow(int[] nums,int goal){
        if(goal <0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;
           while(j<nums.length){
         sum += nums[j];
          
         while(sum>goal && i<j){
            sum -= nums[i];
            i++;
         }
         
          if(sum <= goal){
            count += j-i+1;
         }

         j++;
        }
        return count;
    }



    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums,goal) - slidingWindow(nums,goal-1);
    }
}