class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outDegree = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            for(int neg : graph[i]){
                outDegree[i]++;
            }
        }
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            revGraph.add(new ArrayList<>());
        }
     
         for(int i = 0;i<graph.length;i++){
            for(int neg : graph[i]){
                revGraph.get(neg).add(i);

            }
         }
         List<Integer> ans = new ArrayList<>();
         Queue<Integer> q = new LinkedList<>();
         for(int i = 0;i<outDegree.length;i++){
            if(outDegree[i] == 0){
             q.offer(i);
            }
         }

         while(!q.isEmpty()){
            int x = q.remove();
            ans.add(x);
            for(int neg: revGraph.get(x)){
                outDegree[neg]--;
                if(outDegree[neg] == 0){
                    q.offer(neg);
                }
            }
         }
        Collections.sort(ans);
        return ans;
    }
}