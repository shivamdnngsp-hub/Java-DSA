class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer> mpp = new HashMap<>();
       int i = 0;
       int j = 0;
       int max = 0;
       while(j< s.length()){
         if(!mpp.containsKey(s.charAt(j))){
            mpp.put(s.charAt(j),j);
         }else{
            if(mpp.get(s.charAt(j))>=i){
                i = mpp.get(s.charAt(j))+1;
            }
            mpp.put(s.charAt(j), j);
         }
         max = Math.max(max,j-i+1);
         j++;
       }

     return max;
    }
}