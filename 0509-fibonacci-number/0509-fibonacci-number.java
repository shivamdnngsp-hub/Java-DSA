class Solution {

    int fb(int n,int[] dp){
        if(n<= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        return dp[n] = fb(n-1,dp) + fb(n-2,dp);
    }

    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        fb(n,dp);
        if(n==0) return 0;
        if(n==1) return 1;
        return dp[n];
    }
}