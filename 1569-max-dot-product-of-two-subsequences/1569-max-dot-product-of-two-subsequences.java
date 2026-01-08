class Solution {
    int[] a, b;
    int[][] dp;
    int n, m;
    final int NEG = (int) -1e9;

    int solve(int i, int j) {
        if (i == n || j == m) return NEG;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int take = a[i] * b[j];
        return dp[i][j] = Math.max(
            Math.max(take, take + solve(i + 1, j + 1)),
            Math.max(solve(i + 1, j), solve(i, j + 1))
        );
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        a = nums1; b = nums2;
        n = a.length; m = b.length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        return solve(0, 0);
    }
}
