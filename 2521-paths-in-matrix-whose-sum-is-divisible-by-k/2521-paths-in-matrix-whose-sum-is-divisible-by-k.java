class Solution {

    static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m + 1][n + 1][k];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1 && j == 1) {
                    dp[1][1][grid[0][0] % k] = 1;
                    continue;
                }

                int v = grid[i - 1][j - 1] % k;

                for (int r = 0; r < k; r++) {
                    int need = r - v;
                    if (need < 0) need += k;

                    long up = dp[i - 1][j][need];
                    long left = dp[i][j - 1][need];

                    dp[i][j][r] = (up + left) % MOD;
                }
            }
        }
        return (int) dp[m][n][0];
    }
}
