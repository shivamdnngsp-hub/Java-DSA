class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int i = 0;
        int j;
        int maxSum  = 0;
        int max = Integer.MIN_VALUE;
        for(j = k;j<nums.length;j++){
           max = Math.max(max,nums[i]);
           maxSum = Math.max(maxSum,nums[j]+max);
          i++;
        }
        return maxSum;
    }
}