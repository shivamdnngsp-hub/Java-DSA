class Solution {
    class Pair {
     int row ;
     int col;
     Pair(int row,int col){
        this.row = row;
        this.col = col;
     }
    }

    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                q.offer(new Pair(0, i));
                visited[0][i] = true;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[grid.length - 1][i] == 1 && !visited[grid.length - 1][i]) {
                q.offer(new Pair(grid.length - 1, i));
                visited[grid.length - 1][i] = true;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] == 1 &&!visited[i][grid[0].length - 1]) {
                visited[i][grid[0].length - 1] = true;
                q.offer(new Pair(i, grid[0].length - 1));
            }
        }
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int i = 0;i<4;i++){
                int nr = dr[i] + p.row;
                int nc = dc[i] + p.col;
                if(nr >= 0 && nr < grid.length && nc>= 0 && nc <  grid[0].length){
                    if(grid[nr][nc] ==1 && !visited[nr][nc]){
                         visited[nr][nc] = true;
                         q.offer(new Pair(nr,nc));
                    }
                }
            }
        }
        int count = 0;

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                  count++;
                }
            }
        }

   return count;
        
    }
}