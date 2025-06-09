class Solution {
    private int solve(int n, int k) {
        int now = 1;
        k--;
        while (k > 0) {
            int cnt = calc(n, now, now + 1);
            if (cnt <= k) {
                now++;
                k -= cnt;
            } else {
                now *= 10;
                k--;
            }
        }
        return now;
    }

    private int calc(int n, long a, long b) {
        int res = 0;
        while (a <= n) {
            res += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return res;
    }

    public int findKthNumber(int n, int k) {
        return solve(n, k);
    }
}