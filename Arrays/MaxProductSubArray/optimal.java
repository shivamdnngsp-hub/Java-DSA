package arrays.maxProductSubarray;

public class optimal {
    static int maxProduct(int[] arr) {
        int prefix = 1;
        int suffix = 1;
        int prefixMax = Integer.MIN_VALUE;
        int suffixMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) prefix = 1;
            prefix = prefix * arr[i];
            prefixMax = Integer.max(prefix, prefixMax);
            suffix = suffix * arr[arr.length - i - 1];
            suffixMax = Integer.max(suffix, suffixMax);
        }

        return Integer.max(prefixMax, suffixMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
