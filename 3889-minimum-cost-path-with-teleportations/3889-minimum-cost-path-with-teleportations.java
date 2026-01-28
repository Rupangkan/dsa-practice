class Solution {

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] r : dp) Arrays.fill(r, Integer.MAX_VALUE);

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{i, j});

        cells.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        while (k-- >= 0) {
            int best = Integer.MAX_VALUE;
            for (int i = 0, s = 0; i < cells.size(); i++) {
                int x = cells.get(i)[0], y = cells.get(i)[1];
                best = Math.min(best, dp[x][y]);

                if (i + 1 < cells.size() &&
                    grid[x][y] == grid[cells.get(i + 1)[0]][cells.get(i + 1)[1]])
                    continue;

                for (int j = s; j <= i; j++) {
                    int r = cells.get(j)[0], c = cells.get(j)[1];
                    dp[r][c] = best;
                }
                s = i + 1;
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (i + 1 < m)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + grid[i + 1][j]);
                    if (j + 1 < n)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + grid[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
