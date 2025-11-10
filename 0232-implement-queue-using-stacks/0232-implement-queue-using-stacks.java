class MyQueue {
    Stack<Integer> st;
    Stack<Integer> st2;

    public MyQueue() {
        st = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!st.isEmpty()) {
            st2.add(st.pop());
        }
        st.add(x);
        while(!st2.isEmpty()) {
            st.add(st2.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */