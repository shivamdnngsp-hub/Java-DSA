package arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class optimal {
    public static int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
     for(int i = 0; i< arr.length;i++){
         if(result.isEmpty() || arr[i][0] > result.getLast()[1]){
             result.add(arr[i]);
         }else { 
result.getLast()[1] =   Math.max(result.getLast()[1], arr[i][1]);
         }

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
