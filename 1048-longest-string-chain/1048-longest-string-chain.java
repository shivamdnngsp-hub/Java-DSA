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

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[][] dp = new int[words.length + 1][words.length + 1];
        for(int i = words.length-1;i>= 0;i--){
            for(int j = i-1;j>= -1;j--){
                int skip = dp[i+1][j+1];
                int pick = 0;
                if(j == -1 || cmp(i,j,words)){
                    pick = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(skip,pick);
            }
        }
        return dp[0][0];
    }
}