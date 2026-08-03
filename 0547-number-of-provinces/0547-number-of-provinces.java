class Solution {

    void helper(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neg : graph.get(node)) {
            if (!visited[neg]) {
                helper(graph, visited, neg);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

            }
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                helper(graph, visited, i);
            }
        }

        return ans;
    }
}