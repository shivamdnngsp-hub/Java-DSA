class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<triangle.size();i++){
            for(int j = 0;j<triangle.get(i).size();j++){
              if(j == 0){
                dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
              }else if(j == triangle.get(i).size()-1){
                dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
              }else{
                dp[i][j] = triangle.get(i).get(j)  + Math.min(dp[i-1][j-1],dp[i-1][j]);
              }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < triangle.get(triangle.size()-1).size(); j++) {
            ans = Math.min(ans, dp[triangle.size()-1][j]);
        }

        return ans;
    }
}