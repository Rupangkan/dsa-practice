class Solution {
    public int numSub(String s) {
        int mod = 1000000007, n = s.length();
        long ans = 0, run = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') run++;
            else {
                ans = (ans + run * (run + 1) / 2) % mod;
                run = 0;
            }
        }
        ans = (ans + run * (run + 1) / 2) % mod;
        return (int) ans;
    }
}
