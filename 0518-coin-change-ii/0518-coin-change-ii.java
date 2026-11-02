class Solution {
    int helper(int i,int amount,int[] coins,int[][] dp){
     if(i>= coins.length){
        if(amount == 0){
            return 1;
        }
        return 0;
     }
     if(dp[i][amount] != -1){
        return dp[i][amount];
     }

      int pick = 0;
      if(coins[i]<=amount){
         pick = helper(i,amount-coins[i],coins,dp);
      }
     
     int skip = helper(i+1,amount,coins,dp);
       return dp[i][amount] = pick + skip;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
         return helper(0,amount,coins,dp);
    }
}