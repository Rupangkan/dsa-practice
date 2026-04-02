class Solution {

    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][] dp = new int[n + 1][3];

        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -(int)1e9);
        for (int k = 0; k < 3; k++) dp[1][k] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                int v = coins[i][j - 1];

                int a2 = Math.max(Math.max(dp[j - 1][2] + v, dp[j][2] + v),
                                  Math.max(dp[j - 1][1], dp[j][1]));
                int a1 = Math.max(Math.max(dp[j - 1][1] + v, dp[j][1] + v),
                                  Math.max(dp[j - 1][0], dp[j][0]));
                int a0 = Math.max(dp[j - 1][0], dp[j][0]) + v;

                dp[j][2] = a2;
                dp[j][1] = a1;
                dp[j][0] = a0;
            }
        }

        return dp[n][2];
    }
}