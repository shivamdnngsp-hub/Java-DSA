class Solution {
    public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length -1;
    int max = Math.max(nums[0]*nums[1]*nums[n], nums[n]*nums[n-1]*nums[n-2]);
return max;
    }
}