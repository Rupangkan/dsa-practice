class Solution {
    public int maxCollectedFruits(int[][] a) {
        int n = a.length, s = 0;
        for (int i = 0; i < n; i++) s += a[i][i];

        for (int k = 0; k < 2; k++) {
            if (k == 1) {
                for (int i = 0; i < n; i++)
                    for (int j = i + 1; j < n; j++) {
                        int t = a[i][j];
                        a[i][j] = a[j][i];
                        a[j][i] = t;
                    }
            }

            int[] dp = new int[n], ndp = new int[n];
            Arrays.fill(dp, -1);
            dp[n - 1] = a[0][n - 1];

            for (int r = 1; r < n - 1; r++) {
                Arrays.fill(ndp, -1);
                for (int i = 0; i < n; i++) {
                    if (dp[i] < 0) continue;
                    if (i > 0) ndp[i - 1] = Math.max(ndp[i - 1], dp[i] + a[r][i - 1]);
                    ndp[i] = Math.max(ndp[i], dp[i] + a[r][i]);
                    if (i + 1 < n) ndp[i + 1] = Math.max(ndp[i + 1], dp[i] + a[r][i + 1]);
                }
                int[] tmp = dp; dp = ndp; ndp = tmp;
            }

            s += dp[n - 1];
        }

        return s;
    }
}