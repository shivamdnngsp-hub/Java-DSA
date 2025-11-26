package arrays.MergeIntervals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class brute {
public static int[][] merge(int[][] arr){
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    List<int[]> result = new ArrayList<>();
    int i = 0;
    while(i< arr.length){
        int start = arr[i][0];
        int end = arr[i][1];
        int j  = i+1;
        while(j< arr.length && arr[j][0]<= end){
            end  = Math.max(end, arr[j][1]);
            j++;
        }
        result.add(new int[]{start, end});
        i = j;
    }

    return  result.toArray(new int[result.size()][]);
}

    public static void main(String[] args) {
        int[][] arr = {
                {15, 17},
                {1, 3},
                {2, 6},
                {10, 11}
        };
        System.out.println(Arrays.deepToString(merge(arr)));

    }
}
