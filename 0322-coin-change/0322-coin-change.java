class Solution {
 public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i = 0;i<=coins.length;i++){
            for(int j = 0;j<= amount;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(j ==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = coins.length-1;i>=0;i--){
            for(int amt = 0;amt<=amount;amt++){
                int pick = Integer.MAX_VALUE;
                if(coins[i]<=amt && dp[i][amt - coins[i]] != Integer.MAX_VALUE){
                    pick = 1 + dp[i][amt - coins[i]];
                }
                int skip = dp[i+1][amt];
                dp[i][amt] = Math.min(skip,pick);
            }
        }

        
return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
    }
}