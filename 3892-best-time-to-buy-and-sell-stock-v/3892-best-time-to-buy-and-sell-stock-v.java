class Solution {
    public long maximumProfit(int[] a, int k) {
        int n = a.length;
        long[][] dp = new long[k + 1][3];

        for (int j = 1; j <= k; j++) {
            dp[j][1] = -a[0];
            dp[j][2] = a[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0],
                        Math.max(dp[j][1] + a[i], dp[j][2] - a[i]));
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - a[i]);
                dp[j][2] = Math.max(dp[j][2], dp[j - 1][0] + a[i]);
            }
        }
        return dp[k][0];
    }
}
