class Solution {

    public boolean sum(int[] nums, int x, int threshold) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + x - 1) / x;
        }

        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        for (int i = 1; i <= max; i++) {
            if (sum(nums, i, threshold)) {
                return i;
            }
        }

        return -1;
    }
}
