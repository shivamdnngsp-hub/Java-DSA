class Solution {

    void helper(int[][] isConnected,boolean[] visited, int node) {
        visited[node] = true;
        for(int i = 0;i<isConnected.length;i++){
            if(!visited[i] && isConnected[node][i] == 1){
                helper(isConnected,visited,i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
       
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                helper(isConnected, visited, i);
            }
        }

        return ans;
    }
}