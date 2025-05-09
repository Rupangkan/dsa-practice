class Solution {
    private static final long MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        int n = num.length(), s = 0;
        int[] a = new int[10];
        for (char c : num.toCharArray()) {
            int d = c - '0';
            a[d]++;
            s += d;
        }
        if ((s & 1) != 0) return 0;
        int t = s / 2, m = (n + 1) >> 1;
        long[][] c = new long[m + 1][m + 1], dp = new long[t + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
        }
        dp[0][0] = 1;
        int sum = 0, cnt = 0;
        for (int d = 0; d <= 9; d++) {
            cnt += a[d];
            sum += d * a[d];
            for (int o = Math.min(cnt, m); o >= Math.max(0, cnt - (n - m)); o--) {
                int e = cnt - o;
                for (int val = Math.min(sum, t); val >= Math.max(0, sum - t); val--) {
                    long cur = 0;
                    for (int j = Math.max(0, a[d] - e); j <= Math.min(a[d], o) && d * j <= val; j++) {
                        long ways = (c[o][j] * c[e][a[d] - j]) % MOD;
                        cur = (cur + ways * dp[val - d * j][o - j]) % MOD;
                    }
                    dp[val][o] = cur;
                }
            }
        }
        return (int) dp[t][m];
    }
}