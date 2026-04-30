class Solution {
    // Optimal 
    // O (n + m)
    // O (n + 1001)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 4, 1, 2, 3, 5, 8, 2, 1, 3, 4, 1
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[10001];

        for(int i = m-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            if(st.isEmpty()) nge[nums2[i]] = -1;
            else nge[nums2[i]] = st.peek();
            st.push(nums2[i]);
        }

        int[] res = new int[n];
        for(int i = 0; i<n; i++) {
            res[i] = nge[nums1[i]];
        }
        return res;
    }
}