class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        
        int mid = (nums.length)/2;
        int ele = nums[mid];
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == ele){
                count++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }
}