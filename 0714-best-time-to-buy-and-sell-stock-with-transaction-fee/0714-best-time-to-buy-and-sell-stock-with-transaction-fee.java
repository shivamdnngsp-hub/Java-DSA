class Solution {
    int helper(int i,int buy,int fee,int[] prices,int[][] dp){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy] != Integer.MIN_VALUE){
            return dp[i][buy];
        }

        if(buy == 1){
            int buyy = -prices[i] + helper(i+1,0,fee,prices,dp);
            int skip = helper(i+1,1,fee,prices,dp);
            return dp[i][buy] = Math.max(buyy,skip);
        }
        int sell = prices[i] -fee + helper(i+1,1,fee,prices,dp);
        int skip = helper(i+1,0,fee,prices,dp);
        return dp[i][buy] = Math.max(sell,skip);

    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] arr : dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        
        return helper(0,1,fee,prices,dp);
    }
}