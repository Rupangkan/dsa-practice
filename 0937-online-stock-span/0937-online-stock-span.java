class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int idx;

    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx += 1;
        while(!st.isEmpty() && st.peek().first <= price) {
            st.pop();
        }
        int ans = idx - (st.isEmpty() ? -1 : st.peek().second);
        st.push(new Pair(price, idx));
        return ans; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */