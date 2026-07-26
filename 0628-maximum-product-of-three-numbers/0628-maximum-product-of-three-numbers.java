class Solution {
    public int maximumProduct(int[] nums) {

    int max = Integer.MIN_VALUE;
    int secmax = Integer.MIN_VALUE;
    int thirdmax = Integer.MIN_VALUE;
    int small  = Integer.MAX_VALUE;
    int secsmall = Integer.MAX_VALUE;

    for(int i = 0;i<nums.length;i++){
        if(nums[i]>max){
            thirdmax = secmax;
            secmax = max;
            max = nums[i];
        }else{
            if(nums[i]>secmax){
                thirdmax = secmax;
                secmax = nums[i];
            }
            else if(nums[i]>thirdmax){
                thirdmax = nums[i];
            }
        }

        if(nums[i]<small){
            secsmall = small;
            small = nums[i];
        }else{
            if(nums[i]<secsmall){
                secsmall = nums[i];
            }
        }


    }
return  Math.max(small*secsmall*max, max*secmax*thirdmax);
    }
}