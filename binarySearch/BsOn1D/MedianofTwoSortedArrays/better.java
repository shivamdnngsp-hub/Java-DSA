class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cur = 0;
        int prev = 0;
        int count = 0;
        int total = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        while (count <= total / 2) {
            prev = cur;
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                cur = nums1[i];
                i++;

            } else {
                cur = nums2[j];
                j++;
            }
            count++;
        }

        if (total % 2 != 0) {
            return cur;
        }

        return (cur + prev) / 2.0;

    }
}
