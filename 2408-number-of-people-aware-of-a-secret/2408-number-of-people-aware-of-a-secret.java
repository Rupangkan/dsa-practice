class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] f = new long[n+1];
        f[1] = 1;
        long mod = (long)1e9+7, cur = 0;
        for (int i = 2; i <= n; i++) {
            if (i-delay > 0) cur = (cur+f[i-delay])%mod;
            if (i-forget > 0) cur = (cur-f[i-forget]+mod)%mod;
            f[i] = cur;
        }
        long ans = 0;
        for (int i = n-forget+1; i <= n; i++) ans = (ans+f[i])%mod;
        return (int)ans;
    }
}
