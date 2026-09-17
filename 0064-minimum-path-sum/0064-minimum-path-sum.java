class Solution {
    int  helper(int i,int j,int m,int n,int[][] grid,int[][] dp){
      if(i>= m || j >= n) return Integer.MAX_VALUE;
      if(i == m-1 && j == n-1) return grid[i][j];

      if(dp[i][j] >= 0){
        return dp[i][j];
      }

      int right = helper(i,j+1,m,n,grid,dp);
      int down = helper(i+1,j,m,n,grid,dp);

      right = right == Integer.MAX_VALUE ? right : grid[i][j] + right;
      down = down == Integer.MAX_VALUE ? down : grid[i][j] + down;

      return dp[i][j] = Math.min(right,down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(0,0,m,n,grid,dp);
    }
}