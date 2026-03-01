class Solution {
    public boolean isValid(String s) {
   ArrayDeque<Character> st = new ArrayDeque<>();
     for(int i = 0;i<s.length();i++){
        char c = s.charAt(i);
        if(c == '{' || c == '[' || c == '('){
            st.push(c);
        }else{
            if(st.isEmpty()) return false;
            if(
            (c ==')' && st.peek() != '(') ||
            (c =='}' && st.peek() != '{') ||
            (c ==']' && st.peek() != '[') 
            ){
                return false;
            }
            st.pop();
        }
     }
     return st.isEmpty();
    }
}
