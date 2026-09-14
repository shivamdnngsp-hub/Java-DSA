class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
       int pre1 = Math.max(nums[1],nums[0]);
       int pre2 = nums[0];
       int cur = 0;
       for(int i = 2;i<nums.length-1;i++){
          cur = Math.max(pre1,nums[i] + pre2);
          pre2 = pre1;
          pre1 =cur;
       }
       int a1 = pre1;
       pre2 = nums[1];
       pre1 = Math.max(nums[1],nums[2]);
       for(int i = 3;i<nums.length;i++){
        cur = Math.max(pre1,nums[i] + pre2);
          pre2 = pre1;
          pre1 =cur;
       }
       
       return Math.max(a1,pre1);

    }
}