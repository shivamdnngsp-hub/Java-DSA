class MinStack {
        Stack<Long> st;
        long min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long value = val;
        if(st.isEmpty()){
            st.push(value);
            min = value;
            return;
        }
      if(value<min){
        long encoded = 2*value - min;
        min = value;
        st.push(encoded);
        return;
    }
    st.push(value);
    }
    
    
    public void pop() {
        if (st.isEmpty()) return;
        if(st.peek()<min){
       min = 2*min - st.peek();
        }
        st.pop();
     }
    
    
    
    public int top() {
        if (st.isEmpty()) return -1;
        if(st.peek()< min){
            return (int)min;
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
   if (st.isEmpty()) return -1;
        return (int) min; 
    }
}
