class Solution {
    int helper(int i,int j,int m,int n,int[][] obstacleGrid,int[][] dp){

    if(i >=m || j>= n){
        return 0;
      }
      if(obstacleGrid[i][j] == 1){
        return 0;
      }
      if(i == m-1 && j== n-1){
        return 1;
      }

      if(dp[i][j] != 0){
        return dp[i][j];
      }

      int right = helper(i,j+1,m,n,obstacleGrid,dp);
      int down = helper(i+1,j,m,n,obstacleGrid,dp);
      return dp[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return helper(0,0,m,n,obstacleGrid,dp);

    }
}