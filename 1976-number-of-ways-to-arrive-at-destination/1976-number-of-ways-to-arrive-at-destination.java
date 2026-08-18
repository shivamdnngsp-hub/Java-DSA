class Solution {
    class Pair{
        int node;
        long weight;
        Pair(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,w));
        }

        long[] time = new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        time[0] = 0;
       long[] ways = new long[n];
     ways[0] = 1;

PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
pq.offer(new Pair(0,0));
long MOD = 1000000007L;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
        
            for(Pair neg : graph.get(p.node)){
                
                if(p.weight + neg.weight < time[neg.node]){
                    time[neg.node] = p.weight + neg.weight;
                    pq.offer(new Pair(neg.node , time[neg.node]));
                    ways[neg.node] = ways[p.node];
                }else if(p.weight + neg.weight == time[neg.node]){
                    ways[neg.node] = (ways[neg.node] + ways[p.node])%MOD;
                }
            }
        }
        
return (int)(ways[n - 1] % MOD);
        
    }
}