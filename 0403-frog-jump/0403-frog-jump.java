class Solution {
    public boolean canCross(int[] stones) {
         int n = stones.length;
        boolean[][] dp = new boolean[n][n+1];
        dp[0][0] = true;

        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0;i<n;i++){
            mpp.put(stones[i],i);
        }

        for(int i = 0;i<n;i++){
            for(int jump = 0; jump <= n;jump++){
                 if(!dp[i][jump]){
                    continue;
                 }
               for(int k = -1;k<= 1;k++){
                 int nextJump = jump + k;
                 if(nextJump <= 0) continue;
                 int nextpos = stones[i] + nextJump;
                
                if(mpp.containsKey(nextpos)){
                 int newindex = mpp.get(nextpos);
                 if(newindex == n-1) return true;
                  dp[newindex][nextJump] = true;
                }
               }
            }
        } 
return false;
    }
}