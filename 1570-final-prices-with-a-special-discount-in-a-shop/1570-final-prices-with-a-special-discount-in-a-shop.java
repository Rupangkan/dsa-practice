class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = prices.clone();
        int n = prices.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                ans[st.pop()] -= prices[i];
            }
            st.add(i);
        }

        return ans;
    }
}