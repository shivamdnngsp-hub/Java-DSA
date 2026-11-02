class Solution {
    
    int helper(int i,int[] nums,int target,int[][] dp){ 
      if(i >= nums.length){
        if(target==0){
            return 1;
        }
        return 0;
      }
      
      if(dp[i][target] != -1){
        return dp[i][target];
      }

      int skip = helper(i+1,nums,target,dp);
      int pick = 0;
      if(nums[i]<= target){
      pick = helper(i+1,nums,target-nums[i],dp);
      }

      return dp[i][target] =  pick + skip;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
         if(target>total || target < -total){
            return 0;
         }
          if((total + target)%2 != 0){
            return 0;
          }
         
         int req = (total+target)/2;
        int[][] dp = new int[nums.length+1][req + 1];
         for(int[] x : dp){
            Arrays.fill(x,-1);
         }
        return helper(0,nums,req,dp);
    }
}