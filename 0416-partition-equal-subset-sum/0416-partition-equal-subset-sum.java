class Solution {
    
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
        if(total % 2 != 0){
            return false;
        }
        
        boolean[] cur = new boolean[total/2 +1];
        boolean[] next  = new boolean[total/2+1];
        next[0] = true;
        if(nums[nums.length-1]<=total/2){
            next[nums[nums.length -1]] = true;
        }

        for(int i = nums.length -2;i>= 0;i--){
            for(int s = 0;s<=total/2;s++){
                boolean skip = next[s];
                boolean pick = false;
                if(nums[i]<=s){
                  pick = next[s-nums[i]];
                }
                cur[s] = skip || pick;
            }
            boolean[] temp = cur;
                cur = next;
                next = temp;
        }

        return next[total/2];
    }
}