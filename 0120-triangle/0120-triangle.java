class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1;i<triangle.size();i++){
            for(int j = triangle.get(i).size()-1;j>=0;j--){
                if(j == 0){
                    dp[j] = triangle.get(i).get(j) + dp[j];
                }else if(j == triangle.get(i).size()-1){
                    dp[j] = triangle.get(i).get(j) + dp[j-1];
                }else{
                    dp[j] = triangle.get(i).get(j)  + Math.min(dp[j],dp[j-1]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<triangle.size();i++){
           ans = Math.min(ans,dp[i]);
        }
        return ans;
    }
}