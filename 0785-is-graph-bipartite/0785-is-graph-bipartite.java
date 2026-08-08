class Solution {

    boolean helper(int node, int[][] graph, int[]visited, int set) {
      if(visited[node] != 0){
        if(visited[node] != set){
            return false;
        }
        return true;
      }

        visited[node] = set;
        for (int neg : graph[node]) {
            if (set == -1) {
                if(!helper(neg, graph, visited, -2)) return false;
            } else {
               if(!helper(neg, graph, visited, -1)) return false;
            }
        }
        return true;
    }



    public boolean isBipartite(int[][] graph) {
       int[] visited = new int[graph.length];
       for(int i = 0;i<graph.length;i++){
         if(visited[i] == 0){
            if(!helper(i,graph,visited,-1)) return false;
         }
       }
        return true;
    }
}