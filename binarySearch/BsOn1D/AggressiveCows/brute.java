import java.util.*;

class Solution {

    public boolean canBePlaced(int[] arr, int min, int k) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= min) {
                count++;
                last = arr[i];
            }
        }

        return count >= k;
    }

    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);

        for (int i = 1; i <= arr[arr.length - 1] - arr[0]; i++) {
            if (canBePlaced(arr, i, k)) {
                continue;
            } else {
                return i - 1;
            }
        }

        return  arr[arr.length - 1] - arr[0];
    }
}
