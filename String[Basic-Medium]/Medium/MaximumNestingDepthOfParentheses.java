class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for(int i = 0;i<s.length();i++){
         char c = s.charAt(i);
            if(c == '('){
                count++;
                max = Math.max(count,max);
            }else if(c ==')'){
                count--;
            }
        }
        return max;
    }
}
