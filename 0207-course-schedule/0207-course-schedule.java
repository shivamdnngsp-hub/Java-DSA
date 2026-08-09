class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     List<List<Integer>> graph = new ArrayList<>();
     for(int i = 0;i<numCourses;i++){
        graph.add(new ArrayList<>());
     }
      int[] indegree = new int[numCourses];

      for(int i = 0;i<prerequisites.length;i++){
         int u = prerequisites[i][0];
         int v = prerequisites[i][1];
         graph.get(v).add(u);
         indegree[u]++;
      }

Queue<Integer> q = new LinkedList<>();
for(int i = 0;i< indegree.length;i++){
    if(indegree[i] == 0){
      q.offer(i);
    }
}

int count = 0;

while(!q.isEmpty()){
int node = q.remove();
count++;
for(int neg : graph.get(node)){
    indegree[neg]--;
    if(indegree[neg] == 0){
        q.offer(neg);
    }
}
}

return count == numCourses;
    }
}