class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i< nums.length;i++){
        max = Math.max(max,nums[i]);
        min = Math.min(min,nums[i]);
        }

     while (min != 0) {
    int temp = min;
    min = max % min;
    max = temp;
}

return max;
    }
}