class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length +1][2];
        for(int[] arr : dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }

        dp[prices.length-1][1] = 0;
        dp[prices.length -1][0] = prices[prices.length-1];
        

        for(int i = prices.length-2;i>=0;i--){
            int profit = 0;
            for(int buy = 0;buy<=1;buy++){
              if(buy == 1){
                  profit = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
              }else{
                profit = Math.max(prices[i] + dp[i+1][1],dp[i+1][0]);
              }
              dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
}