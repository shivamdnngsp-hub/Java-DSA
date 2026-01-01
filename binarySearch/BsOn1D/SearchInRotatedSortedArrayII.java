public class random {
    static boolean search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return true;
            if ((arr[mid] == arr[high]) && (arr[mid] == arr[low])) {
                low++;
                high--;
                continue;
            }


            if (arr[low] <= arr[mid]) {

                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            else {

                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {6,7,1,2,3,4,5};
        int x = 7;
        System.out.println(search(arr, x));
    }
}
