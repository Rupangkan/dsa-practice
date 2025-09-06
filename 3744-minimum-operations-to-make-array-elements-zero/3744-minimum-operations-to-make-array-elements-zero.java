class Solution {
    private long calc(int n) {
        long ans = 0;
        for (int i = 1, b = 1; b <= n; i++, b <<= 1) {
            int r = Math.min((b << 1) - 1, n);
            ans += 1L * ((i + 1) >> 1) * (r - b + 1);
        }
        return ans;
    }

    public long minOperations(int[][] q) {
        long res = 0;
        for (int[] p : q) {
            res += (calc(p[1]) - calc(p[0] - 1) + 1) >> 1;
        }
        return res;
    }
}
