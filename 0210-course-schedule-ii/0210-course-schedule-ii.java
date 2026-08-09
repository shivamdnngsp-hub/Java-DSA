class Solution {
    List<Integer> ans = new ArrayList<>();
    boolean helper(int node, List<List<Integer>> graph,boolean[] visited,boolean[] pathVisited){
       if(pathVisited[node]){
        return true;
       }
      
       pathVisited[node] = true;
       visited[node] = true;
       for(int neg : graph.get(node)){
        if(!visited[neg]){
            if(helper(neg,graph,visited,pathVisited)) return true;
        }else if(pathVisited[neg]){
            return true;
        }
       }
     ans.add(node);
pathVisited[node] = false;
return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!visited[i]){
                if(helper(i,graph,visited,pathVisited)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(ans);
        int[] arr = new int[ans.size()];

for(int i = 0; i < ans.size(); i++){
    arr[i] = ans.get(i);
}

return arr;
    }
}