class Solution {
    int helper(int i, int[] prices, int[][][] dp, int buy, int tr,int k) {
        if (i == prices.length) {
            return 0;
        }
        if (tr == k) {
            return 0;
        }

        if (dp[i][buy][tr] != Integer.MIN_VALUE) {
            return dp[i][buy][tr];
        }

        if (buy == 1) {
            int buyy = -prices[i] + helper(i + 1, prices, dp, 0, tr,k);
            int skip = helper(i + 1, prices, dp,1, tr,k);
            return dp[i][buy][tr] = Math.max(buyy, skip);
        }

        int sell = prices[i] + helper(i + 1, prices, dp, 1, tr + 1,k);
        int skip = helper(i + 1, prices, dp,0, tr,k);
        return dp[i][buy][tr] = Math.max(sell, skip);

    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return helper(0,prices, dp, 1, 0,k);
    }
}