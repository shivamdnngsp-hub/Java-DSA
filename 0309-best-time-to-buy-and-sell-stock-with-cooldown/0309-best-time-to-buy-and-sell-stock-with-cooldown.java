class Solution {
    int helper(int i, int buy, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != Integer.MIN_VALUE) {
            return dp[i][buy];
        }

        if (buy == 1) {
            int buyy = -prices[i] + helper(i + 1, 0, prices, dp);
            int skip = helper(i + 1, 1, prices, dp);
            return dp[i][buy] = Math.max(buyy, skip);
        }
        int sell = prices[i] + helper(i + 2, 1, prices,dp);
        int skip = helper(i + 1, 0, prices,dp);
        return dp[i][buy] = Math.max(sell, skip);

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return helper(0, 1, prices, dp);
    }
}