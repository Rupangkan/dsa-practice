class Solution {
    static final int MOD = 1_000_000_007, MAX = 31;
    static final long[] F = new long[MAX], IF = new long[MAX];
    static {
        F[0] = 1;
        for (int i = 1; i < MAX; i++) F[i] = F[i - 1] * i % MOD;
        IF[MAX - 1] = fp(F[MAX - 1], MOD - 2);
        for (int i = MAX - 1; i > 0; i--) IF[i - 1] = IF[i] * i % MOD;
    }
    static long fp(long a, int b) {
        long r = 1;
        for (; b > 0; b >>= 1, a = a * a % MOD) if ((b & 1) > 0) r = r * a % MOD;
        return r;
    }
    public int magicalSum(int m, int k, int[] a) {
        int n = a.length;
        int[][] pw = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pw[i][0] = 1;
            for (int j = 1; j <= m; j++) pw[i][j] = (int)((long)pw[i][j - 1] * a[i] % MOD);
        }
        int[][][][] dp = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] x : dp) for (int[][] y : x) for (int[] z : y) Arrays.fill(z, -1);
        return (int)(dfs(0, m, 0, k, pw, dp) * F[m] % MOD);
    }
    long dfs(int i, int m, int c, int k, int[][] pw, int[][][][] dp) {
        int b = Integer.bitCount(c);
        if (b + m < k) return 0;
        if (i == pw.length) return (m == 0 && b == k) ? 1 : 0;
        if (dp[i][m][c][k] != -1) return dp[i][m][c][k];
        long res = 0;
        for (int j = 0; j <= m; j++) {
            int bit = (c + j) & 1;
            if (bit <= k)
                res = (res + dfs(i + 1, m - j, (c + j) >> 1, k - bit, pw, dp) * pw[i][j] % MOD * IF[j]) % MOD;
        }
        return dp[i][m][c][k] = (int)res;
    }
}
