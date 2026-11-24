// why sort ?
// let say i have [5,9,18,54,108,540,90,180,360,720]
// and till now i have 9 → 18 → 54 → 108 → 540
// now let say 90 comes up it will check 90%540 == 0 NO 540%90 == 0 NO
// but 9 → 18 → 90 → 180 → 360 → 720 90 can be part of subswt if order was this
// thats why we sort 
// pick = new ArrayList<>(helper(i + 1, nums, i, dp));
// // as let say this runs 
// if(dp[i][prevI +1] != null){
//             return dp[i][prevI+1];
//         }
// dp[i][prevI+1] is returned;
// now if i add elent in it it will chnage its state;
// so thats why i create a new copy...
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[nums.length + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[nums.length][i] = new ArrayList<>();
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int prevI = i - 1; prevI >= -1; prevI--) {
                List<Integer> skip = dp[i + 1][prevI + 1];
                List<Integer> pick = new ArrayList<>();
                if (prevI == -1 || nums[i] % nums[prevI] == 0) {
                    pick = new ArrayList<>(dp[i + 1][i + 1]);
                    pick.add(nums[i]);
                }
                dp[i][prevI + 1] = pick.size() > skip.size() ? pick : skip;
            }
        }
        return dp[0][0];
    }
}