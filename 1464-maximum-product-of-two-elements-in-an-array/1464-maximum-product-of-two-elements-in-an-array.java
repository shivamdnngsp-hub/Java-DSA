class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for(int ele : nums){
            if(ele > max){
                secMax = max;
                 max = ele;
            }else{
                if(ele>secMax){
                    secMax = ele;
                }
            }
        }
        return (max-1) * (secMax -1);
    }
}