class Solution {

    public int[] getFloorAndCeil(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int floor = -1;
        int ceil = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
                ceil = mid;
            }
            if (arr[mid] <= x) {
                low = mid + 1;
                floor = mid;
            }


        }
        return new int[]{arr[floor], arr[ceil]};

    }
}
