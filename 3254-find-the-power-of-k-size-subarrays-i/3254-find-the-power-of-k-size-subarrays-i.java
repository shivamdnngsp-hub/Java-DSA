class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int prev = nums[i];
        int[] ans = new int[nums.length -k +1];
        int index = 0;
        while(j<nums.length){

while(j-i+1>k){
            i++;
           }


           if(nums[j] != prev+1){
              while(i<j){
                if(index <ans.length){
                    ans[index] = -1;
                }
                // ans[index] = -1;
                index++;
                i++;
              }
           }

        //     while(j-i+1>k){
        //     i++;
        //    }

           if(j-i+1 == k){
            ans[index] = nums[j];
            index++;
           }

           prev = nums[j];
            j++;
        }
        return ans;
    }
}