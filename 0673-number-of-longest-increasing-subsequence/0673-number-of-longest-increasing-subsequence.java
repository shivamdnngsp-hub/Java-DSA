class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }

        int max = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                ans = count[i];
            } else if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }
}