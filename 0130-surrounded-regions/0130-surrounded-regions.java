class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                q.offer(new Pair(0, i));
                visited[0][i] = true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length - 1][i] == 'O' && !visited[board.length - 1][i]) {
                q.offer(new Pair(board.length - 1, i));
                visited[board.length - 1][i] = true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O' &&!visited[i][board[0].length - 1]) {
                visited[i][board[0].length - 1] = true;
                q.offer(new Pair(i, board[0].length - 1));
            }
        }

        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = p.row + dr[i];
                int nc = p.col + dc[i];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if (board[nr][nc] == 'O'&& !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new Pair(nr, nc));
                    }
                }
            }

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}