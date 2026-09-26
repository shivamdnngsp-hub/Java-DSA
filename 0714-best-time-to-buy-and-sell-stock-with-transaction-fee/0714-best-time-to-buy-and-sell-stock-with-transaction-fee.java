class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[prices.length+1][2];
        dp[n-1][1] = 0;
        dp[n-1][0] = prices[n-1] - fee;

        for(int i = n-2;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                  int buyy = -prices[i] + dp[i+1][0];
                  int skip = dp[i+1][1];
                  dp[i][buy] = Math.max(buyy,skip);
                }else{
                   int sell = prices[i] + dp[i+1][1] - fee;
                   int skip = dp[i+1][0];
                   dp[i][buy] = Math.max(sell,skip);
                }
            }
        }
        return dp[0][1];
    }
}