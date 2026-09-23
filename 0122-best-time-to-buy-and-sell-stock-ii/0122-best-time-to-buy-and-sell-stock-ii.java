// at evry index i have 2 option i cannn buy or i sell if i can buy(again i have 2 option either skip it or buy it) and if i can sell(i again have 2 options sell or skip);
// now i know base case 
// dp[prices.length-1][1] = 0; its max profit if i can buy last index obiously if i buy it i will be in profit of (-pirces[n-1]) and skip it profit will be 0 so i will choose max that is 0;

// dp[prices.length -1][0] = prices[prices.length-1]; if i sell it i will get profit of (+prices[n-1]) and skipped it profit will be 0 so i will choose prices[n-1];

// now let say i have indes (i) and i can buy it... so if I can buy it profit can be
// if I bougt it profit will be -prices[i] + dp[i+1][0] why 0 as if i buy it next i caanot buy next index so its state will be 0 and
// if i skip it profit will be dp[i+1][1] why 1 as i can buy the next index;
// i will take max of this profit;
// same logic for if i can sell



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