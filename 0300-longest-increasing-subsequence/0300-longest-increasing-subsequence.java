// binary serach method.. i will maiain list tail, tails[i] represents the smallest possible ending value of an increasing subsequence so far, as jitni samll ending hogi more emets i can append, 
// note the final length will be the ans  but finall elemts will not be the actual longest subsequnece
// i will appned the elemt if it is gretaer then last elemt of list or replace it 



class Solution {
    int lowerbound(int ele, List<Integer> list) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= ele) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            if (l.isEmpty()||num>l.get(l.size()-1)) {
                l.add(num);
            } else {
                int lb = lowerbound(num, l);
                l.set(lb, num);
            }
        }
        return l.size();
    }
}
