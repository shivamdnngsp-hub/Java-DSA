class Solution {
    int timer = 1;
    boolean[] vis;
    int[] time;
    int[] low;
    List<List<Integer>> ans = new ArrayList<>();

    void dfs(int node,int parent,List<List<Integer>> graph){
        vis[node] = true;
        time[node] = timer;
        low[node] = timer;
        timer++;

        for(int neg : graph.get(node)){
            if(neg == parent) continue;
            if(!vis[neg]){
               dfs(neg,node,graph);
               low[node]  = Math.min(low[node],low[neg]);

            if(low[neg] > time[node]){
                ans.add(Arrays.asList(neg,node));
            }
            }else{
                low[node] = Math.min(low[node],time[neg]);
            }
            
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i< n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> x : connections){
            int u  = x.get(0);
            int v = x.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        vis = new boolean[n];
        time = new int[n];
        low = new int[n];

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,-1,graph);
            }
        }


        return ans;
    }
}