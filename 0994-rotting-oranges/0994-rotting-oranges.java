class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int time = 0;
        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                Pair p = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nr = p.row + dRow[k];
                    int nc = p.col + dCol[k];
                    if (nr >= 0 && nr < grid.length &&
                            nc >= 0 && nc < grid[0].length &&
                            grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new Pair(nr, nc));
                        rotted = true;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}