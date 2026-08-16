class Solution {
    class Pair{
        int node;
        int price;
        int level;
        Pair(int node,int price,int level){
            this.node = node;
            this.price = price;
            this.level = level;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph.get(u).add(new Pair(v,w,0));
        }

        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src] = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(src,0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
             if (p.level > k) {
              continue;
            }

            for(Pair neg: graph.get(p.node)){
                if(p.price + neg.price  < price[neg.node] && p.level +1<= k+1){
                    price[neg.node] = p.price + neg.price;
                    pq.offer(new Pair(neg.node,price[neg.node],p.level +1));
                }
            }
               
            }

    
if(price[dst] == Integer.MAX_VALUE){
    return -1;
}


return price[dst];
    }
}