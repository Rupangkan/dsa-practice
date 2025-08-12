class Solution {
    final int M = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int v = (int)Math.pow(i, x);
            if (v > n) break;
            for (int j = n; j >= v; j--) dp[j] = (dp[j] + dp[j - v]) % M;
        }
        return (int)dp[n];
    }
}