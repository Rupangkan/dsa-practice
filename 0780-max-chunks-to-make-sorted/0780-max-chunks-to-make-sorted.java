class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++) {
            if(st.isEmpty() || arr[i] > st.peek()) {
                st.push(arr[i]);
            } else {
                int max = st.peek();
                while(!st.isEmpty() && arr[i] < st.peek()) {
                    st.pop();
                }
                st.push(max);
            }
        }

        return st.size();
    }
}