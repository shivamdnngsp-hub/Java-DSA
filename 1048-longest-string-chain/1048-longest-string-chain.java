class Solution {
    boolean cmp(int i, int prevI, String[] words) {
        if (words[i].length() - 1 != words[prevI].length()) {
            return false;
        }
        for (int k = 0; k < words[i].length(); k++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.deleteCharAt(k);
            if (sb.toString().equals(words[prevI])) {
                return true;
            }
        }
        return false;
    }

    int helper(int i,int prevI,String[] words,int[][] dp){
       if(i== words.length){
        return 0;
       }
       if(dp[i][prevI+1] != -1){
        return dp[i][prevI+1];
      }
       int skip = helper(i+1,prevI,words,dp);
       int pick = 0;
       if(prevI == -1 || cmp(i,prevI,words)){
         pick = 1+helper(i+1,i,words,dp);
       }
       return dp[i][prevI+1] = Math.max(pick,skip);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[][] dp = new int[words.length + 1][words.length + 1];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return helper(0, -1, words, dp);
    }
}