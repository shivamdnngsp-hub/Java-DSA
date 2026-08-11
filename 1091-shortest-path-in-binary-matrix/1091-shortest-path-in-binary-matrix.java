class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    Queue<Pair> q = new LinkedList<>();
    int[] dr = {-1,1,0,0,-1,1,-1,1};
    int[] dc = {0,0,1,-1,1,1,-1,-1};
    q.offer(new Pair(0,0,0));
    visited[0][0] = true;
   
    while(!q.isEmpty()){
        Pair p = q.remove();
        if(p.row ==grid.length -1 && p.col == grid[0].length-1) return p.dis +1;
        for( int i = 0;i<8;i++){
            int nr = p.row + dr[i];
            int nc = p.col + dc[i];
            if(nr>= 0 && nr<grid.length && nc>= 0&& nc <grid[0].length && grid[nr][nc] != 1 && !visited[nr][nc]){
                visited[nr][nc] = true;
                q.offer(new Pair(nr,nc,p.dis+1));
            }
        }
    }




return -1;
    }
}