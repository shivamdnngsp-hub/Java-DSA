package arrays.MergeSortedArray;

import java.util.Arrays;

public class brute {
static void merge(int[] num1, int m, int[] num2 , int n){
    int i = m;
    int  j = 0;
    while(i<n+m){
        num1[i] = num2[j];
        i++;
        j++;
    }
    Arrays.sort(num1);

}

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
