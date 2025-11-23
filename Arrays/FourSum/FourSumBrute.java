package arrays.FourSum;
import java.util.*;
public class FOURSumBrute {
    static List<List<Integer>> s4Sum(int[] arr, int target) {
        Set<List<Integer>> l = new HashSet<>();
        for(int i= 0; i< arr.length-3;i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                for (int k = j + 1; k < arr.length - 1; k++) {
                    for (int M = k + 1; M < arr.length; M++) {
                        if (arr[i] + arr[j] + arr[k] + arr[M] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[M]);
                            Collections.sort(temp);
                            l.add(temp);
                        }
                    }
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
