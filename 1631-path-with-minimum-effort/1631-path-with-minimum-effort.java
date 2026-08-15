class Solution {
    class Pair{
        int effort;
        int row;
        int col;
        Pair(int effort,int row,int col){
            this.effort = effort;
            this.row= row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.offer(new Pair(0,0,0));
        int[][] maxE = new int[heights.length][heights[0].length];
for (int i = 0; i < maxE.length; i++) {
    Arrays.fill(maxE[i], Integer.MAX_VALUE);
}
        maxE[0][0] = 0;

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
             for(int i = 0;i<4;i++){
                int nr = p.row + dr[i];
                int nc = p.col + dc[i];
                if(nr >= 0 && nr <heights.length && nc >= 0 && nc < heights[0].length){
                    int diff  = Math.abs(heights[nr][nc] - heights[p.row][p.col]);
                    int effort = Math.max(diff,maxE[p.row][p.col]);
                    if(effort < maxE[nr][nc]){
                        maxE[nr][nc] = effort;
                        pq.offer(new Pair(effort,nr,nc));
                    }
                }
             }
        }


return maxE[heights.length-1][heights[0].length-1];
    }
}