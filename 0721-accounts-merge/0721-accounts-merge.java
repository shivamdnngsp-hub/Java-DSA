class Solution {
     

    void dfs(String s ,List<String> l, Map<String,List<String>> m2,HashSet<String> visited){
      l.add(s);
      visited.add(s);
      for(String val : m2.get(s)){
        if(!visited.contains(val)){
            dfs(val,l,m2,visited);
        }
      }
     }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> m1 = new HashMap<>();
        Map<String,List<String>> m2 = new HashMap<>();

        for(List<String> x : accounts){
           String userName = x.get(0);
           for(int i = 1;i<x.size();i++){
            m1.put(x.get(i),userName);
            m2.putIfAbsent(x.get(i), new ArrayList<>());
            for(int j = 1;j<x.size();j++){
                if(i!= j){
                    m2.get(x.get(i)).add(x.get(j));
                }
            }
           }
        }


        HashSet<String> visited = new HashSet<>();
       List<List<String>> ans = new ArrayList<>();
        for(String s : m2.keySet()){
            if(!visited.contains(s)){
                List<String>  l = new ArrayList<>();
                l.add(m1.get(s));
                dfs(s,l,m2,visited);
                Collections.sort(l.subList(1, l.size()));
                ans.add(l);
            }
        }

        


return ans;


    }
}