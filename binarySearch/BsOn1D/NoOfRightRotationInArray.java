public class random {
    static int noOfRotation(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        while(low<= high){
            int mid = low + (high-low)/2;
            if(arr[low]<= arr[mid]){

                if(arr[low]<= min){
                    min = arr[low];
                    minIndex = low;
                }
                low = mid+1;

            }
            else {
                if(arr[mid]<=min){
                    min = arr[mid];
                    minIndex = mid;
                }
                high = mid-1;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,0};
        System.out.println(noOfRotation(arr));
    }
}
