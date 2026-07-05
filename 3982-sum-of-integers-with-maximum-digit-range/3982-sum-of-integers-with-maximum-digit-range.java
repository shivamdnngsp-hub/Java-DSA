class Solution {
    public int maxDigitRange(int[] nums) {
        int ans = 0;
        int maxRating = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        
        for(int i = 0;i<nums.length;i++){
            int number = nums[i];
            int max = 0;
            int min = 9;
            while(number>0){
                int ld = number%10;
                min = Math.min(min,ld);
                max = Math.max(max,ld);
                number = number/10;
            }
            maxRating = Math.max(maxRating,max-min);
            mpp.put(i,max-min);
        }

        for(int i = 0;i<mpp.size();i++){
            if(mpp.get(i) == maxRating){
                ans += nums[i];
            }
        }

return ans;
        
    }
}