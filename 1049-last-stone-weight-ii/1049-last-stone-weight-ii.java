class Solution {
 
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int x : stones){
            total += x;
        }
       boolean[][] dp = new boolean[stones.length+1][total+1];
       dp[stones.length-1][0] = true;
       dp[stones.length -1][stones[stones.length-1]] = true;
       for(int i = stones.length -2;i>=0;i--){
        for(int s  = 0; s<= total;s++){
            boolean skip = dp[i+1][s];
            boolean  pick = false;
            if(stones[i]<=s){
                pick = dp[i+1][s - stones[i]];
            }
            dp[i][s] = skip || pick;
        }
       }
       int closest = 0;
       for(int i = 0;i<stones.length;i++){
        for(int s = 0;s<=total/2;s++){
            if(dp[i][s] == true){
                if(closest <= s && s<= total/2){
                    closest = s;
                }
            } 
        }
       }
       return total - 2*closest;

    }
}

