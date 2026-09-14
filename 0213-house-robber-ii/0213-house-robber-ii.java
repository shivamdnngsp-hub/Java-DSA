class Solution {
   
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[1],nums[0]);
        }

        int n = nums.length-1;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<=n-1;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        int a1 = dp[n-1];

        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = Math.max(nums[2],nums[1]);
        for(int i = 3;i<=n;i++){
          dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        int a2 = dp[n];
        return Math.max(a1,a2);
     
    }
}