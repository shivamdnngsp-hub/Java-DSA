class Solution {
    int ans = 0;
    int helper(int i,int[] nums,int[] dp){
     if(i>=nums.length){
        return 0;
     }
     if(dp[i] != -1){
        return dp[i];
     }

     return dp[i] = Math.max(nums[i] + helper(i+2,nums,dp),helper(i+1,nums,dp));
    }


    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
}