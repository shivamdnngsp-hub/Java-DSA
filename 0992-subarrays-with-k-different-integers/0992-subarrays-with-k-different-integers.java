class Solution {
    public int window(int[] nums, int k, Map<Integer, Integer> mpp) {
      
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length) {
            mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
            while (mpp.size() > k && i <= j) {
                mpp.put(nums[i], mpp.get(nums[i]) - 1);
                if (mpp.get(nums[i]) == 0) {
                    mpp.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
            j++;

        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
         int x = window(nums,k,mpp);
         mpp.clear();
         int y = window(nums,k-1,mpp);
         return x-y;
     }
}