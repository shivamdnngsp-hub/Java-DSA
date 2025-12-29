public class random {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};

        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
            else if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
            }
        }

        System.out.println(secMax);
    }
}
