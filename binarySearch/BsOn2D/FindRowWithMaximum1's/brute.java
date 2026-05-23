class Solution {
    public int rowWithMax1s(int[][] mat) {
       
        int max = -1;
        int maxIndex = -1;

        for(int i = 0; i < mat.length; i++){
            int count = 0;

            for(int j = 0; j < mat[0].length; j++){
                count += mat[i][j];
            }

            if(count > max && count != 0){
                max = count;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
