class Solution {
    
    int helper(int i,int[] nums,int target){ 
      if(i >= nums.length){
        if(target==0){
            return 1;
        }
        return 0;
      }
      return helper(i+1,nums,target-nums[i]) + helper(i+1,nums,target+nums[i]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target);
    }
}