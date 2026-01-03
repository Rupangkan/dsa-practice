class Solution {
    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        long a = 6, b = 6;
        for (int i = 2; i <= n; i++) {
            long na = (2 * a + 2 * b) % mod;
            long nb = (2 * a + 3 * b) % mod;
            a = na;
            b = nb;
        }
        return (int)((a + b) % mod);
    }
}
