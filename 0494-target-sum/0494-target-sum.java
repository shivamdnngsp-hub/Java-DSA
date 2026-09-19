class Solution {
    int count = 0;
    void helper(int i,int sum,int[] nums,int target){
        if(i >= nums.length){
            
            if(sum == target){
                count++;
            }
            return;
        }
         helper(i+1,sum + nums[i],nums,target);
         helper(i+1,sum - nums[i],nums,target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        helper(0,0,nums,target);
        return count;
    }
}