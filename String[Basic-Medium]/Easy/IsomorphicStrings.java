class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>  h1 = new HashMap<>();
        Map<Character,Character>  h2 = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(h1.containsKey(c1)){
                if(h1.get(c1) != c2 ){
                    return false;
                }
            }else if(h2.containsKey(c2)){
                if(h2.get(c2) != c1){
                    return false;
                }
            }else{
                h1.put(c1,c2);
                h2.put(c2,c1);
            }

        }
        return true;

    }
}
