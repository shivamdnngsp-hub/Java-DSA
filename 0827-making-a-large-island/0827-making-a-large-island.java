class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }

        boolean union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (xp == yp)
                return false;

            if (size[xp] > size[yp]) {
                parent[yp] = xp;
                size[xp] += size[yp];
            } else if (size[yp] > size[xp]) {
                parent[xp] = yp;
                size[yp] += size[xp];
            } else {
                parent[yp] = xp;
                size[xp] += size[yp];
            }
            return true;
        }

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        DSU dsu = new DSU(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = i;
                int c = j;
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        dsu.union(r * n + c, nr * n + nc);
                    }
                }
            }
        }

        int size = Integer.MIN_VALUE;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;

                int r = i;
                int c = j;
                hasZero = true;
                HashSet<Integer> s = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        s.add(dsu.find(nr * n + nc));
                    }
                }
                int sum = 1;
                for (int x : s) {
                    sum += dsu.size[x];
                }
                size = Math.max(size, sum);
            }
        }
if(!hasZero){
    return n*n;
}
        return size;

    }
}