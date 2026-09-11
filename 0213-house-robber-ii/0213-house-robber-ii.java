class Solution {
    int helper(int i,int[]nums, int[] dp,int n){
        if(i>n){
            return 0;
        }
       if(dp[i] != -1){
        return dp[i];
       }
        return dp[i] = Math.max(nums[i] + helper(i+2,nums,dp,n),helper(i+1,nums,dp,n));
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length-1;
        int[] dp1 = new int[n+1];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[n+1];
        Arrays.fill(dp2,-1);
        return Math.max(helper(1,nums,dp1,n),helper(0,nums,dp2,n-1));
    }
}