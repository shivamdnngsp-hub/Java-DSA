package arrays.MergeSortedArray;
import java.util.Arrays;
public class optimal {
    static void merge(int[] num1, int m, int[] num2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (num1[i] < num2[j]) {
                num1[k] = num2[j];
                j--;
            } else {
                num1[k] = num1[i];
                i--;
            }
            k--;
        }
        while (j >= 0) {
            num1[k] = num2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
