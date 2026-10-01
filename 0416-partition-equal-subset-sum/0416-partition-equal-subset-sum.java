class Solution {
    boolean helper(int i,int total,int[] nums,Boolean[][] dp){
        if(i >= nums.length){
            if(total == 0){
                return true;
            }
            return false;
        }
        if(total<0){
            return false;
        }
        if(dp[i][total] != null){
            return dp[i][total];
        }
        return dp[i][total] = helper(i+1,total -nums[i],nums,dp) || helper(i+1,total,nums,dp);
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
        if(total % 2 != 0){
            return false;
        }
        Boolean[][] dp = new Boolean[nums.length+1][total+1];
        return helper(0,total/2,nums,dp);
    }
}