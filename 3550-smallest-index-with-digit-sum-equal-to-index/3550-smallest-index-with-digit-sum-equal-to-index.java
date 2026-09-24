class Solution {
    int sum(int n){
        int summ = 0;
        while(n>0){
          int ld = n%10;
          summ += ld;
          n  = n/10;
        }
        return summ;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++){
             if(sum(nums[i])== i){
              return i;
             }
        }
        return -1;
    }
}