class Solution {

    public int window(int[] nums, int k) {
      if(k<0){
        return 0;
      }
        int i = 0;
        int j = 0;
        int count = 0;
        int oddCount = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                oddCount++;
            }
            while(oddCount > k && i<=j) {
                if(nums[i]%2 != 0){
                    oddCount--;
                }
                i++;
            }

            if (oddCount <=  k) {
              count += j-i+1;
            }
            j++;
        }
        return count;

    }

    public int numberOfSubarrays(int[] nums, int k) {

        return window(nums,k) - window(nums,k-1);
    }
}