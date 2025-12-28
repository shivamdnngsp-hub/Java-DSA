static int lowerBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] arr = {3, 5, 8, 15, 19};
        System.out.println(search(arr, target));
    }
