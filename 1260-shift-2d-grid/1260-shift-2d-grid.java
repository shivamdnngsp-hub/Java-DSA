class Solution {


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    
       int[][] arr = new int[grid.length][grid[0].length];
       for(int i = 0;i<grid.length;i++){
        for(int j = 0;j<grid[0].length;j++){
            int index = i*grid[0].length +j;
            int newIndex = (index+k)%(grid.length*grid[0].length);
            int x = newIndex/grid[0].length;
            int y = newIndex%grid[0].length;
            arr[x][y] = grid[i][j];
        }
       }

List<List<Integer>> ans = new ArrayList<>();
for(int[] row : arr){
List<Integer> l = new ArrayList<>();
for(int i = 0;i<row.length;i++){
    l.add(row[i]);
}
ans.add(l);
}


      return ans;  
    }
}