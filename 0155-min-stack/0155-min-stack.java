class MinStack {
    Stack<Long> st;
    Long mini;

    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            mini = (long)val;
            st.push((long)val);
        } else {
            if(val > mini) {
                st.push((long)val);
            } else {
                st.push((long)2*val-mini);
                mini = (long)val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long top = st.peek();
        st.pop();

        if(top < mini) {
            mini = (long)2 * mini - top;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long top = st.peek();

        if(top < mini) {
            return mini.intValue();
        } else {
            return (int)top;
        }
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */