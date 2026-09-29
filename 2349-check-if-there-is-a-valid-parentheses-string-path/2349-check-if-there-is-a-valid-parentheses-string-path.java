class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int len = n + m - 1;

        if ((len & 1) == 1 || grid[0][0] != '(' || grid[n - 1][m - 1] != ')')
            return false;

        boolean[][][] dp = new boolean[n][m][len + 1];
        dp[0][0][1] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int change = grid[i][j] == '(' ? 1 : -1;

                if (i > 0) {
                    for (int b = 0; b <= len; b++) {
                        if (dp[i - 1][j][b] && b + change >= 0)
                            dp[i][j][b + change] = true;
                    }
                }

                if (j > 0) {
                    for (int b = 0; b <= len; b++) {
                        if (dp[i][j - 1][b] && b + change >= 0)
                            dp[i][j][b + change] = true;
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}