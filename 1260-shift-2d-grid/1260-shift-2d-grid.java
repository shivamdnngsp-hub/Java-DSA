class Solution {

    void rotate(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>  ans = new ArrayList<>();

        int[] arr = new int[grid.length * grid[0].length];
        int x = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                arr[x] = grid[i][j];
                x++;
            } 
        }

        k = k%arr.length;
        rotate(arr,0,arr.length-1);
        rotate(arr,0,k-1);
        rotate(arr,k,arr.length-1);
        x = 0;
        for(int i = 0;i<grid.length;i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0;j<grid[0].length;j++){
                l.add(arr[x]);
                x++;
            }
            ans.add(l);
        }
       
      return ans;
        
    }
}