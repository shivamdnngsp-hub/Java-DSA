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
// so thats why i create a new copy
class Solution {
List<Integer> helper(int i, int[] nums, int prevI,List<Integer>[][] dp) {
        if (i == nums.length) {
            return new ArrayList<>();
        }
        if(dp[i][prevI +1] != null){
            return dp[i][prevI+1];
        }

        List<Integer> skip = helper(i + 1, nums,prevI,dp);
         List<Integer> pick = new ArrayList<>();
        if (prevI == -1 || nums[i] % nums[prevI] == 0) {
            pick = new ArrayList<>(helper(i + 1, nums, i, dp));
            pick.add(nums[i]);
        }
        return dp[i][prevI+1] =  pick.size() > skip.size() ? pick : skip;
    }

    public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[nums.length+1][nums.length + 1];;
        return helper(0,nums,-1,dp);
    }
}