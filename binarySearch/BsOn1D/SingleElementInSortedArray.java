public class random {
    static int singleElement(int[] arr) {

        if (arr.length == 1) return arr[0];
        else if (arr[0] != arr[1]) return arr[0];
        else if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 1;
                } else if (arr[mid] == arr[mid - 1]) {
                    high = mid - 1;
                } else {
                    return arr[mid];
                }
            } else {

                if (arr[mid] == arr[mid + 1]) {
                    high = mid - 1;
                } else if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else {
                    return arr[mid];
                }

            }

        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(singleElement(arr));
    }
}
