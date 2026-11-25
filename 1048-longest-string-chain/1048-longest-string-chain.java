// space optimzation 
// study LIS first
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
        int dp[] = new int[words.length];
        int ans = 0;
        for(int i = 0;i<words.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
              if(cmp(i,j,words) && dp[j] + 1 > dp[i]){
                dp[i] = 1 + dp[j];
              }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}