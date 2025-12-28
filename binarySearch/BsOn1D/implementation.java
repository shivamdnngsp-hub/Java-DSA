package binarySearch.BinarySearchtofindXinsortedarray;

public class brute {

    static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                low = mid + 1;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int target = -1;
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(arr, target));
    }
}








