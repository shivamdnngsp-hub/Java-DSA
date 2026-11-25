// space optimazation
class Solution {
    public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length+1];
    int ans = 0;
    for(int i = 0;i<nums.length;i++){
        dp[i] = 1;
        for(int j = 0;j<i;j++){
           if(nums[i]>nums[j] && dp[j]+1 > dp[i]){
            dp[i] = 1 + dp[j];
           }
        }
        ans = Math.max(dp[i],ans); 
        // max length nikalni hai, so ya toe mai esse kr lo or last mai dp pae for loop lga kae max nikal lu;
    }
    return ans;
    }
}
