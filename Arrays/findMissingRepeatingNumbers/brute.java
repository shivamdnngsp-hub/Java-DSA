package arrays.findMissingRepeatingNumbers;

import java.util.Arrays;

public class brute {
    static int[] findMissingRepeatingNumbers(int[] arr) {
        int missing = 1;
        int repeating = 1;
        for(int i = 1; i<= arr.length;i++){
            int count  = 0;
            for(int j = 0; j< arr.length;j++){
                if(arr[j] == i){
                    count++;
                }
            }
            if(count == 0){
                missing = i;
            }
            else if(count ==2){
                repeating = i;
            }
        }
        int[] brr = new int[2];
        brr[1]= missing;
        brr[0] = repeating;

        return brr;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}
