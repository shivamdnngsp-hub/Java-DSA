class Solution {
  
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

      int pre2 = nums[0];
      int pre1 = Math.max(nums[0],nums[1]);
      int cur = 0;
      for(int i = 2;i<nums.length;i++){
         cur = Math.max(nums[i] + pre2,pre1);
         pre2 = pre1;
         pre1 = cur;
      }

      return pre1;
    }
}