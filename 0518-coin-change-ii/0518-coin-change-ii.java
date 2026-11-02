class Solution {
 
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[coins.length][0] = 1;
         for(int i = coins.length-1;i>=0;i--){
            for(int s = 0;s<=amount;s++){
                int pick = 0;
                if(coins[i]<=s){
                    pick = dp[i][s-coins[i]];
                }
                int skip = dp[i+1][s];
                dp[i][s] = pick + skip;
            }
         }
         return dp[0][amount];
    }
}