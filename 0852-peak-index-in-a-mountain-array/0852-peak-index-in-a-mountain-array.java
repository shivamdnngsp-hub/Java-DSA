class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxi = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                maxi = i;
            }
        }
        return maxi;
    }
}