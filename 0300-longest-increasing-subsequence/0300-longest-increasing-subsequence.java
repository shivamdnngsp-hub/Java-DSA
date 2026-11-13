// i will do skip and pick and only pick if the prepicked elemet is less then the current
// i did prepickedi+1 as -1 is out of bound for array so i just shifted the preindex with 1; 
// function mai toe mai normal vala prepikcedi pass kr raha hu
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length +1][nums.length+1];
         for(int i = nums.length-1;i>=0;i--){
            for(int p = i-1;p>= -1;p--){
                int skip = dp[i+1][p+1];
                int pick = 0;
                if(p == -1 || nums[i]>nums[p]){
                    pick = 1+dp[i+1][i+1];
                }
                dp[i][p+1] = Math.max(pick,skip);
            }
         }
        return dp[0][0];
    }
}