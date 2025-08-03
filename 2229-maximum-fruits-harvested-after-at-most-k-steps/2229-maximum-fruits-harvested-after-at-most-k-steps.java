class Solution {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        return solve(fruits, startPos, k);
    }

    private int solve(int[][] a, int sp, int limit) {
        int l = 0, r = 0, n = a.length, total = 0, res = 0;
        while (r < n) {
            total += a[r][1];
            while (l <= r && move(a, sp, l, r) > limit) {
                total -= a[l][1];
                l++;
            }
            res = Math.max(res, total);
            r++;
        }
        return res;
    }

    private int move(int[][] a, int sp, int l, int r) {
        int left = Math.abs(sp - a[l][0]), right = Math.abs(sp - a[r][0]);
        return Math.min(left, right) + a[r][0] - a[l][0];
    }
}
