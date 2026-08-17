class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph.get(u).add(new Pair(v,w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight- b.weight);
        pq.offer(new Pair(k,0));
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = -1;
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(Pair neg : graph.get(p.node)){

                if(dist[p.node] + neg.weight < dist[neg.node]){
                    dist[neg.node] = dist[p.node] + neg.weight;
                    pq.offer(new Pair(neg.node,dist[neg.node]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x :dist ){
            max = Math.max(max,x);
        }
return max == Integer.MAX_VALUE ? -1 : max;
    }
}