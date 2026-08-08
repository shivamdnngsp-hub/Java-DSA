class Solution {
    boolean helper(int node,int numCourses,List<List<Integer>> graph,boolean[] pathVisited,boolean[] visited){

         if(pathVisited[node] == true){
            return true;
        }

        visited[node] = true;
        pathVisited[node] = true;

    

        for(int neg : graph.get(node)){
            if(!visited[neg]){
               if(helper(neg,numCourses,graph,pathVisited,visited)) return true;
            }else if(pathVisited[neg]){
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
   
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
                if(helper(i,numCourses,graph,pathVisited,visited)){
                    return false;
                }
            }
        }


return true;
    }
}