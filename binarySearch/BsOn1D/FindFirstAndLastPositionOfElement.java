
    static int[] searchRange(int[] arr, int target) {
        int low1 = 0;
        int high1 = arr.length - 1;
        int start = -1;
        while (low1 <= high1) {
            int mid = low1 + (high1 - low1) / 2;

            if (target == arr[mid]) {
                start = mid;
                high1 = mid-1;
            }

            if (target > arr[mid]) {
                low1 = mid + 1;
            }

            if (target < arr[mid]) {
                high1 = mid - 1;
            }

        }


        int low2 = 0;
        int high2  = arr.length -1;
        int end = -1;
        while (low2 <= high2) {
            int mid = low2 + (high2 - low2) / 2;

            if (target == arr[mid]) {
                low2 = mid+1;
                end = mid;

            }

            if (target > arr[mid]) {
                low2 = mid + 1;
            }

            if (target < arr[mid]) {
                high2 = mid - 1;
            }

        }

        return new int[]{start, end};
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int x = 8;
        for (int y : searchRange(arr, x)) {
            System.out.print(y);
        }
    }
