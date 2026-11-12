// i will do skip and pick and only pick if the prepicked elemet is less then the current
// i did prepickedi+1 as -1 is out of bound for array so i just shifted the preindex with 1; 
// function mai toe mai normal vala prepikcedi pass kr raha hu
class Solution {
    int helper(int i,int prepickedi,int[] nums,int[][] dp){
       if(i == nums.length){
        return 0;
       }

       if(dp[i][prepickedi +1] != -1){
        return dp[i][prepickedi +1];
       }
        int skip = helper(i+1,prepickedi,nums,dp);
        int pick = 0;
        if(prepickedi == -1 || nums[i]>nums[prepickedi]){
          pick = 1+helper(i+1,i,nums,dp);
        }

        return dp[i][prepickedi +1] = Math.max(pick,skip);
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length +1][nums.length+1];
        for(int[]  x: dp){
           Arrays.fill(x,-1);
        }
        return helper(0,-1,nums,dp);
    }
}