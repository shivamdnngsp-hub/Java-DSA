class Solution {

    int fb(int n,int[] dp){
        if(n==1 || n== 2){
            return 1;
        }
        if(n<= 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
return dp[n] = fb(n-1,dp) + fb(n-2,dp) + fb(n-3,dp);

    }

    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
         return fb(n,dp);
    }
}