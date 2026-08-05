class Solution {
     class Pair {
        int row;
        int col;
        int level;

        Pair(int row, int col,int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
         boolean[][] visited = new boolean[isWater.length][isWater[0].length];
         Queue<Pair> q= new LinkedList<>();
         int[][] ans = new int[isWater.length][isWater[0].length];
         for(int i = 0;i<isWater.length;i++){
            for(int j = 0;j<isWater[0].length;j++){
                if(isWater[i][j] == 1){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
         }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

         while(!q.isEmpty()){
            Pair p = q.remove();
            for(int i = 0;i<4;i++){
                int nr = dr[i] + p.row;
                int nc = dc[i] + p.col;
             if(nr >= 0 && nr < isWater.length && nc >= 0 && nc < isWater[0].length && !visited[nr][nc]){
                 ans[nr][nc] = p.level +1;
                 visited[nr][nc] = true;
                 q.offer(new Pair(nr,nc,p.level +1));
             }
            }
         }


         return ans;
        
    }
}