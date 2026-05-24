class Solution {

     public int maxRow(int[][] mat, int mid){
       int max = Integer.MIN_VALUE;
       int maxRowIndex = -1;
        for(int i = 0;i< mat.length;i++){
        if(mat[i][mid] > max){
            max = mat[i][mid];
            maxRowIndex = i;
        }
        }
        return maxRowIndex;
     }


    public int[] findPeakGrid(int[][] mat) {
          int arr[] = new int[2];
     int low = 0;
     int high = mat[0].length - 1;
     while(low<= high){
        int mid = low + (high - low)/2;
        int maxRowIndex =  maxRow(mat, mid);
        int left = mid -1>=0 ? mat[maxRowIndex][mid-1] : -1;
        int right = mid + 1 < mat[0].length ? mat[maxRowIndex][mid+1] : -1;
        if(mat[maxRowIndex][mid]> left && mat[maxRowIndex][mid] > right ){
         arr[0] = maxRowIndex;
         arr[1] = mid;
         return arr;
        }else if(mat[maxRowIndex][mid] < right){
            low = mid +1;
        }else{
            high = mid -1;
        }
     }
     
     arr[0] = -1;
     arr[1] = -1;
     return arr;

    }
}
