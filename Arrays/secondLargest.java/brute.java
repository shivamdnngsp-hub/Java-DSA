import java.util.Arrays;

public class Random {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};

        Arrays.sort(arr); // O(n log n)

        int n = arr.length;
        int max = arr[n - 1];
        int secMax = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != max) {
                secondMax = arr[i];
                break;
            }
        }

        System.out.println(secondMax);
    }
}
