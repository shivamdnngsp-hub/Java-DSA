class Solution {
    public int rowWithMax1s(int[][] mat) {
       int max = -1;
       int maxIndex = -1;
       for(int i = 0;i<mat.length;i++){
         int low = 0;
         int high = mat[0].length -1;
         int firstOccurance  = -1;
         while(low<= high){
            int mid = low + (high -low)/2;
            if(mat[i][mid] == 1){
               firstOccurance = mid;
               high = mid -1;
            }else{
                low = mid +1;
            }
                
            
         }
        if(firstOccurance != -1){
            int count = mat[0].length - firstOccurance;
            if(count>max){
                max = count;
                maxIndex = i;
            }
        }


       }
       return maxIndex;
    }
}
