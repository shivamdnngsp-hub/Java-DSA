class Solution {
    int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i >= triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = helper(i + 1, j, triangle,dp);
        int right = helper(i + 1, j + 1, triangle,dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return helper(0, 0, triangle, dp);
    }
}