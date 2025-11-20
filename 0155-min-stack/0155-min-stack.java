class MinStack {
    // Better would be to use a pair and store value, minimum 

    Stack<Long> st;
    Long mini;

    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = (long)val;
        if(st.isEmpty()) {
            mini = value;
            st.push(value);
        } else {
            if(value < mini) {
                st.push(2 * value - mini);
                mini = value;
            } else {
                st.push(value);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long val = st.pop();
        if(val < mini) {
            mini = 2 * mini - val;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long val = st.peek();
        if(val < mini) {
            return mini.intValue();
        }
        return (int) val;
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