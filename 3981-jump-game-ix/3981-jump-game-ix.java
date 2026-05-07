class Solution {

    record Node(int v, int l, int r) {}

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        List<Node> st = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Node cur = new Node(nums[i], i, i);

            while (!st.isEmpty() && st.getLast().v() > nums[i]) {
                Node t = st.removeLast();
                cur = new Node(
                    Math.max(cur.v(), t.v()),
                    t.l(),
                    cur.r()
                );
            }

            st.add(cur);
        }

        for (Node x : st) {
            for (int i = x.l(); i <= x.r(); i++) {
                ans[i] = x.v();
            }
        }

        return ans;
    }
}