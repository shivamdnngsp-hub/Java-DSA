package arrays.findMissingRepeatingNumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class brute {
    static int[] findMissingRepeatingNumbers(int[] arr) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int a = 1;
        int b = 1;
        for (int i = 0; i < arr.length; i++) {
            if (mpp.containsKey(arr[i])) {
                mpp.put(arr[i], mpp.get(arr[i]) + 1);
                if (mpp.get(arr[i]) == 2) {
                    a = arr[i];
                }
            } else {
                mpp.put(arr[i], 1);
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if (!(mpp.containsKey(i))) {
                b = i;
            }
        }
        int[] brr = new int[2];
        brr[0] = a;
        brr[1] = b;
        return brr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}

