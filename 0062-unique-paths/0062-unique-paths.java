class Solution {
    private int better(int i, int j, int m, int n, int [][] dp) {
        // int count = 0;
        if(i >= n || j >= m) return 0;
        if(i == n - 1 && j == m - 1) return 1;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int down = better(i, j + 1, m, n, dp);
        int right = better(i + 1, j, m, n, dp);
        return dp[i][j] = down + right;
    }

    // Combination problem nCr or nCd
    private int optimal(int m, int n) {
        int N = n + m - 2;
        int D = m - 1;
        long ans = 1;

        for(int i = 1; i<=D; i++) {
            ans = ans * (N - D + i)/i;
        }
        return (int) ans;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int[] a: dp) Arrays.fill(a, Integer.MIN_VALUE);
        // return better(0, 0, m, n, dp);
        return optimal(m, n);
    }
}