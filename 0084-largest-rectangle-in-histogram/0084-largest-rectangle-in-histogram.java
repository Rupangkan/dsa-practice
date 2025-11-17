class Solution {

    private int[] findPrevSmallerElement(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] findNextSmallerElement(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    private int better(int[] h) {
        int n = h.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        nse = findNextSmallerElement(h);
        pse = findPrevSmallerElement(h);
        int max = 0;

        for(int i = 0; i<n; i++) {
            int width = nse[i] - pse[i] - 1;
            max = Math.max(max, h[i] * width);
        }

        return max;
    }

    public int largestRectangleArea(int[] h) {
        return better(h);
    }
}