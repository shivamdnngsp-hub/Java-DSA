class Solution {
    int[] dc = {-1,0,1};
    int helper(int r,int i, int j,int m,int n,int[][] grid,int[][][] dp){
        if(i<0 || j<0 || i>= n || j>= n || r> m-1){
            return 0;
        }
        int ch = 0;
        if(dp[r][i][j] != -1){
            return dp[r][i][j];
        }
if(i == j){
ch  = grid[r][i];
}else{
    ch = grid[r][i] + grid[r][j];
}
        
        
        int max = Integer.MIN_VALUE;
      for(int k = 0;k<3;k++){
        for(int h = 0;h<3;h++){
          max = Math.max(max,ch + helper(r+1,i + dc[k],j + dc[h],m,n,grid,dp));
        }
      }
return dp[r][i][j] = max;
    }

    public int cherryPickup(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
       int[][][] dp = new int[m][n][n];

for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        Arrays.fill(dp[i][j], -1);
    }
}

        return helper(0,0,n-1,m,n,grid,dp);
    }
}