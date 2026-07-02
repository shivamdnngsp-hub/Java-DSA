class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i = 0;
        int j = 0;
        long sum = 0;
        long count = 0;
        while(j<nums.length){
            sum += nums[j];
            long score = sum*(j-i+1);

            while(score>=k && i<=j){
                sum -= nums[i];
                i++;
                score = (long)sum*(j-i+1);
            }

            if(sum < k){
              count += j-i+1;
            }
        j++;
        }
        return count;
    }
}