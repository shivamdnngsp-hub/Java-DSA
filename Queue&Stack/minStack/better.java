class MinStack {
        Stack<Integer> st;
        Stack<Integer> m;
    public MinStack() {
        st = new Stack<>();
        m = new Stack<>();
    }
    
    public void push(int val) {
    if(m.isEmpty() || val<=m.peek()){
        m.push(val);
    }
    st.push(val);
    }
    
    public void pop() {
     if(st.peek().equals(m.peek())){
        m.pop();
     }
     st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return m.peek();
    }
}
