
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int l = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                l++;
                max = Math.max(max, l);
            } else {
                l = 1;
            }
        }
        l = 1;
        int min = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                l++;
                min = Math.max(min, l);
            } else {
                l = 1;
            }
        }
        return Math.max(min, max);
    }
}
