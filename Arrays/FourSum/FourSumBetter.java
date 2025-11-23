package arrays.FourSum;

import java.util.*;

public class FOURSumBetter {

    static List<List<Integer>> s4Sum(int[] arr, int target) {
        Set<List<Integer>> l = new HashSet<>();
        for (int i = 0; i < arr.length-2; i++){
            for(int j = i+1 ; j< arr.length-1;j++){
                Set<Integer> s  = new HashSet<>();
                for(int k = j+1; k<arr.length;k++){
                    int fourth = target-(arr[i]+arr[j]+arr[k]);
                    if(s.contains(fourth)){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        Collections.sort(temp);
                        l.add(temp);
                    }
                    s.add(arr[k]);
                }
            }
        }

        return new ArrayList<>(l);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(s4Sum(arr, target));
    }


}
