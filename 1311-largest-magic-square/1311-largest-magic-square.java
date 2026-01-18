class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] rs = new int[m][n], cs = new int[m][n];

        for (int i = 0; i < m; i++) {
            rs[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) rs[i][j] = rs[i][j - 1] + grid[i][j];
        }

        for (int j = 0; j < n; j++) {
            cs[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) cs[i][j] = cs[i - 1][j] + grid[i][j];
        }

        for (int len = Math.min(m, n); len >= 2; len--) {
            for (int i = 0; i + len <= m; i++) {
                for (int j = 0; j + len <= n; j++) {
                    int sum = rs[i][j + len - 1] - (j > 0 ? rs[i][j - 1] : 0);
                    boolean ok = true;

                    for (int r = i; r < i + len && ok; r++)
                        if (rs[r][j + len - 1] - (j > 0 ? rs[r][j - 1] : 0) != sum)
                            ok = false;

                    for (int c = j; c < j + len && ok; c++)
                        if (cs[i + len - 1][c] - (i > 0 ? cs[i - 1][c] : 0) != sum)
                            ok = false;

                    int d1 = 0, d2 = 0;
                    for (int k = 0; k < len; k++) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + len - 1 - k];
                    }

                    if (ok && d1 == sum && d2 == sum) return len;
                }
            }
        }
        return 1;
    }
}
