package arrays.findMissingRepeatingNumbers;

import java.util.Arrays;

public class optimal {
    static int[] findMissingRepeatingNumbers(int[] arr) {
        int n = arr.length;
        int nSum = (n*(n+1))/2;
        int nSquareSum = ((n)*(n+1)*(2*n+1))/6;
        int sum = 0;
        int squareSum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum+arr[i];
            squareSum = squareSum + arr[i]*arr[i];
        }
int z1 = nSum - sum;
        int z2 = nSquareSum- squareSum;
int z3 = z2/z1;
int missing = (z1 + z3)/2;
int repeating = (z3-z1)/2;
int[] brr = new int[2];
brr[0] = repeating;
brr[1]  = missing;

     return brr;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}
