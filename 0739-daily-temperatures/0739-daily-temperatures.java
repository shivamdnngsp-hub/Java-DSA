class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[temperatures.length];
        for(int  i = temperatures.length-1;i>=0 ;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
           nge[i] = st.isEmpty() ? temperatures.length : st.peek();
           st.push(i);
        }
        for(int i = 0;i<nge.length;i++){
            if(nge[i]== temperatures.length){
              nge[i] = 0;
            }else{
             nge[i] = nge[i] - i;
            }
            
        }


return nge;
    }
}