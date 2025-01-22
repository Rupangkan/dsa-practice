class Solution {
    public int[][] highestPeak(int[][] terrain) {
        int n = terrain.length, m = terrain[0].length, INF = n * m;
        int[][] heights = new int[n][m];
        for (int[] row : heights) Arrays.fill(row, INF);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (terrain[i][j] == 1) heights[i][j] = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (i > 0) heights[i][j] = Math.min(heights[i][j], heights[i - 1][j] + 1);
                if (j > 0) heights[i][j] = Math.min(heights[i][j], heights[i][j - 1] + 1);
            }

        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                if (i < n - 1) heights[i][j] = Math.min(heights[i][j], heights[i + 1][j] + 1);
                if (j < m - 1) heights[i][j] = Math.min(heights[i][j], heights[i][j + 1] + 1);
            }

        return heights;
    }
}