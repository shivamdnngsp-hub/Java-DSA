class Solution {
    int helper(int i,int[] coins,int amount,int[][] dp){

        if(i>=coins.length){
            if(amount == 0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(amount<0){
             return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int pick = helper(i,coins, amount-coins[i],dp);
         if(pick != Integer.MAX_VALUE){
            pick += 1;
        }
        int skip = helper(i+1,coins,amount,dp);
      return dp[i][amount] = Math.min(pick,skip);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }

        int res = helper(0,coins,amount,dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}