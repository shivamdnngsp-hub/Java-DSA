public class random { 
    static int countOccurrences(int[] arr, int target) {

        int low1 = 0;
        int high1 = arr.length - 1;
        int first = -1;

        while (low1 <= high1) {
            int mid = low1 + (high1 - low1) / 2;

            if (arr[mid] == target) {
                first = mid;
                high1 = mid - 1;
            }
            else if (arr[mid] > target) {
                high1 = mid - 1;
            }
            else {
                low1 = mid + 1;
            }
        }

        int low2 = 0;
        int high2 = arr.length - 1;
        int last = -1;

        while (low2 <= high2) {
            int mid = low2 + (high2 - low2) / 2;

            if (arr[mid] == target) {
                last = mid;
                low2 = mid + 1;
            }
            else if (arr[mid] > target) {
                high2 = mid - 1;
            }
            else {
                low2 = mid + 1;
            }
        }

        if (first == -1) return 0;

        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int x = 8;
        System.out.println(countOccurrences(arr, x));
    }
}

