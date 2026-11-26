// do longest mountain in array first;
class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int dp1[] = new int[arr.length];
        int dp2[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                max = Math.max(max, dp1[i] + dp2[i] - 1);
            }
        }
        return arr.length - max;
    }
}