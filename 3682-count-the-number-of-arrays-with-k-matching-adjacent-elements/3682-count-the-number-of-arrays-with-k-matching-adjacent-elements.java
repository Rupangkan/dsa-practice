class Solution {
    final int MOD = 1_000_000_007;
    final int SZ = 100_000;
    long[] F = new long[SZ];
    long[] IF = new long[SZ];

    Solution() {
        F[0] = 1;
        for (int i = 1; i < SZ; i++) F[i] = F[i - 1] * i % MOD;
        IF[SZ - 1] = pw(F[SZ - 1], MOD - 2);
        for (int i = SZ - 1; i >= 1; i--) IF[i - 1] = IF[i] * i % MOD;
    }

    long pw(long a, long b) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) != 0) r = r * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return r;
    }

    long C(int n, int k) {
        return F[n] * IF[k] % MOD * IF[n - k] % MOD;
    }

    private int solve(int n, int m, int k) {
        return (int) (C(n - 1, k) * m % MOD * pw(m - 1, n - k - 1) % MOD);
    }

    public int countGoodArrays(int n, int m, int k) {
        return solve(n, m, k);
    }
}