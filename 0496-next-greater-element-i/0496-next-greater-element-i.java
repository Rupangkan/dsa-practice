class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 4, 1, 2, 3, 5, 8, 2, 1, 3, 4, 1
        Stack<Integer> st = new Stack<>();
        int[] nextG = new int[10001];

        for(int i = nums2.length - 1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            nextG[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for(int i = 0; i<nums1.length; i++) {
            res[i] = nextG[nums1[i]];
        }

        return res;
    }
}