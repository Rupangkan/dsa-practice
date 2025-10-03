class Solution {
    private int findPath(int i, int j, int m, int n, int [][] dp) {
        // int count = 0;
        if(i >= n || j >= m) return 0;
        if(i == n - 1 && j == m - 1) return 1;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int down = findPath(i, j + 1, m, n, dp);
        int right = findPath(i + 1, j, m, n, dp);
        return dp[i][j] = down + right;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int[] a: dp) Arrays.fill(a, Integer.MIN_VALUE);
        return findPath(0, 0, m, n, dp);
    }
}