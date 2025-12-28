package binarySearch.BinarySearchtofindXinsortedarray;

public class recursive {
    static int recursiveSearch(int low, int high, int arr[], int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;

        else if (target < arr[mid])
            return recursiveSearch(low, mid - 1, arr, target);

        else
            return recursiveSearch(mid + 1, high, arr, target);
    }

    static int search(int[] arr, int target) {
        return recursiveSearch(0, arr.length - 1, arr, target);
    }

    public static void main(String[] args) {
        int target = 9;
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(arr, target));
    }
}
