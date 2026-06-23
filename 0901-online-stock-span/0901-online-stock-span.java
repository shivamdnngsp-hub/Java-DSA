class StockSpanner {
  Stack<List<Integer>> st;
    public StockSpanner() {
      st = new Stack<>();
    }
    
    public int next(int price) {
        int i = 1;
        while(!st.isEmpty() && st.peek().get(0) <= price){
           int prevSpan =  st.pop().get(1);
            i += prevSpan;
        }
        st.push(Arrays.asList(price,i));
        return i;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */