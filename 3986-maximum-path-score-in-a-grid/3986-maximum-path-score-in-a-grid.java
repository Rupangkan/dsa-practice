class Solution {

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    int cur = dp[i][j][c];
                    if (cur == Integer.MIN_VALUE) continue;

                    if (i + 1 < m) {
                        int v = grid[i + 1][j];
                        int nc = c + (v == 0 ? 0 : 1);
                        if (nc <= k) {
                            dp[i + 1][j][nc] = Math.max(dp[i + 1][j][nc], cur + v);
                        }
                    }

                    if (j + 1 < n) {
                        int v = grid[i][j + 1];
                        int nc = c + (v == 0 ? 0 : 1);
                        if (nc <= k) {
                            dp[i][j + 1][nc] = Math.max(dp[i][j + 1][nc], cur + v);
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans < 0 ? -1 : ans;
    }
}