// lets make this problem simple s1 - s2 = target and s1 + s2 = target i get s1 = (target+total)/2;
// so i will count subarrys with sum s1; first ensure that s1 is even and target<total or if target is negtaive target < -total


class Solution {
    
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
        dp[nums.length][0] = 1;
        for(int i = nums.length -1;i>=0;i--){
            for(int s  = 0;s<=req;s++){
                int skip = dp[i+1][s];
                int pick = 0;
                if(nums[i]<=s){
                    pick = dp[i+1][s-nums[i]];
                }
                dp[i][s] = pick + skip;
            }
        }
     return dp[0][req];
    }
}