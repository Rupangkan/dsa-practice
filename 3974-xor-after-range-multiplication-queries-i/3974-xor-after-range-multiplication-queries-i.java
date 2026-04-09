class Solution {

    private static final int M = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((nums[i] * 1L * v) % M);
            }
        }

        int ans = 0;
        for (int x : nums) ans ^= x;

        return ans;
    }
}