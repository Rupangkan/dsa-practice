class Solution {
    public int countSquares(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0, pre = 0;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            pre = 0;
            for (int j = 1; j <= m; j++) {
                int tmp = dp[j];
                if (mat[i - 1][j - 1] == 1) {
                    dp[j] = 1 + Math.min(pre, Math.min(dp[j - 1], dp[j]));
                    ans += dp[j];
                } else dp[j] = 0;
                pre = tmp;
            }
        }
        return ans;
    }
}