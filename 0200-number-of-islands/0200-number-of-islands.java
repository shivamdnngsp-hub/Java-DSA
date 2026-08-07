class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }


    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int[] dr = {0,0,1,-1};
        int[] dc = {-1,1,0,0};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '0'){
                    continue;
                }
              if(!visited[i][j]){
                 count++;
                 visited[i][j] = true;
                 q.offer(new Pair(i,j));
                 while(!q.isEmpty()){
                    Pair p = q.remove();
                    for(int l = 0;l<4;l++){
                        int nr = p.row + dr[l];
                        int nc = p.col + dc[l];
                        if(nr>= 0 && nr< grid.length && nc>= 0 && nc< grid[0].length && !visited[nr][nc] && grid[nr][nc] == '1'){
                            visited[nr][nc] = true;
                            q.offer(new Pair(nr,nc));
                        }
                    }
                 }
              }

            }
        } 
        return count;
    }
}