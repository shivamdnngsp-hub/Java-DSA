class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

    int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
    Arrays.fill(dis[i], Integer.MAX_VALUE);
    dis[i][i] = 0;
}
    
    for(int i = 0;i<edges.length;i++){
       int u = edges[i][0];
       int v = edges[i][1];
       int w = edges[i][2];
       dis[u][v] = w;
       dis[v][u] = w;
    }


        for(int  via = 0;via<n;via++){
            for(int i = 0;i<dis.length ;i++){
                for(int j = 0;j<dis[0].length;j++){
                  if(dis[i][via] != Integer.MAX_VALUE && dis[via][j] !=Integer.MAX_VALUE){
                    dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                  }
                }
            }
        }
        int ans = -1;
        int minCount = Integer.MAX_VALUE;

     for(int i = 0;i<dis.length;i++){
        int count = 0;
        for(int j = 0;j<dis[0].length;j++){
            if(dis[i][j] <= distanceThreshold){
                count++;
            }
        }
        if(count <= minCount){
            minCount = count;
            ans = i;
        }
     }

return ans;

    }
}