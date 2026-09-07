class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007, n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];

        Arrays.fill(last, -1);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            dp[i + 1] = (dp[i] * 2) % mod;

            if (last[c] != -1)
                dp[i + 1] = (dp[i + 1] - dp[last[c]] + mod) % mod;

            last[c] = i;
        }

        return (dp[n] - 1 + mod) % mod;
    }
}