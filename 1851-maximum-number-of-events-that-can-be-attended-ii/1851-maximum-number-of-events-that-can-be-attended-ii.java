class Solution {
    private int next(int[][] e, int x) {
        int l = 0, r = e.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (e[m][0] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int solve(int[][] e, int k) {
        int n = e.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(e, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = n - 1; i >= 0; i--) {
            int j = next(e, e[i][1]);
            for (int t = 1; t <= k; t++) {
                dp[t][i] = Math.max(dp[t][i + 1], e[i][2] + dp[t - 1][j]);
            }
        }
        return dp[k][0];
    }

    public int maxValue(int[][] events, int k) {
        return solve(events, k);
    }
}