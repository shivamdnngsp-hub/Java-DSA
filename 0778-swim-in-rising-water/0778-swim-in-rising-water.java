class Solution {
    class Pair {
        int row;
        int col;
        int weight;

        Pair(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] time = new int[n][n];
        for (int[] arr : time) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0, grid[0][0]));
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        time[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Pair p = pq.remove();

            for (int i = 0; i < 4; i++) {
                int nr = p.row + dr[i];
                int nc = p.col + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newtime = Math.max(p.weight,grid[nr][nc]);
                    if (newtime < time[nr][nc]) {
                        time[nr][nc] = newtime;
                        pq.offer(new Pair(nr,nc,newtime));
                    }
                }
            }
        }
        
return time[n-1][n-1];
    }
}