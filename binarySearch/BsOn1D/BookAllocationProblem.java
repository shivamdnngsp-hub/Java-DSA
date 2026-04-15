class Solution {

    public boolean canBeDistributed(int arr[], int min, int m) {
        int student = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= min) {
                sum += arr[i];
            } else {
                student++;
                sum = arr[i];
            }
        }

        return student <= m;
    }

    public int findPages(int[] arr, int m) {
        if (m > arr.length) return -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int sumMax = 0;
        for (int i = 0; i < arr.length; i++) {
            sumMax += arr[i];
        }

        int low = max;
        int high = sumMax;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBeDistributed(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
