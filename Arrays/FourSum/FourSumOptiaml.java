package arrays.FourSum;

import java.util.*;

public class FOURSumBrute {
    static List<List<Integer>> s4Sum(int[] arr, int target) {
        Set<List<Integer>> l = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                 int m= arr.length - 1;
                while (k < m) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[m];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[m]);
                        k++;
                        m--;
                        l.add(temp);
                        while (k < m && arr[k] == arr[k - 1]) k++;
                        while (k < m && arr[m] == arr[m + 1]) m--;
                    } else if (sum > target) {
                        m--;
                    } else k++;

                }
            }
        }
        return new ArrayList<>(l);
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(s4Sum(arr, target));
    }
}
