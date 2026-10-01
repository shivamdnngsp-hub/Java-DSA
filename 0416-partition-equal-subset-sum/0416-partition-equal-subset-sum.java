class Solution {
    
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
        if(total % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length+1][total+1];
        dp[nums.length -1][0] = true;
       if(nums[nums.length -1]<=total){
        dp[nums.length - 1][nums[nums.length - 1]] = true;
       } 
       
        
        for(int i = nums.length -2;i>= 0;i--){
            for(int s = 0;s<=total;s++){
                boolean skip = dp[i+1][s];
                boolean pick = false;
                if(nums[i]<=s){
                  pick = dp[i+1][s -nums[i]];
                }
                dp[i][s] = skip || pick;
            }
        }


        return dp[0][total/2];
    }
}