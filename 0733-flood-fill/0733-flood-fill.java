class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        int original = image[sr][sc];

        if (original == color) {
            return image;
        }
        
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nr = p.row + dRow[k];
                    int nc = p.col + dCol[k];
                    if (nr >= 0 && nr < image.length &&
                            nc >= 0 && nc < image[0].length &&
                            image[nr][nc] == original) {
                        image[nr][nc] = color;
                        q.offer(new Pair(nr, nc));
                    }
                }

            }

        }

        return image;
    }
}