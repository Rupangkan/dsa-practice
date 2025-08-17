class Solution {
    public double new21Game(int n, int k, int m) {
        if (k == 0 || n >= k + m - 1) return 1.0;
        double dp[] = new double[n+1], s = 1, ans = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = s / m;
            if (i < k) s += dp[i]; else ans += dp[i];
            if (i >= m) s -= dp[i-m];
        }
        return ans;
    }
}