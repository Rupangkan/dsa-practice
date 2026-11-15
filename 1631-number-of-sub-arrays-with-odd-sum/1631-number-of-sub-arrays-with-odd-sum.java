class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int[][] dp = new int[2][2];
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int idx = i & 1, parity = arr[i] & 1;

            dp[parity][idx] = (1 + dp[0][1 - idx]) % mod;
            dp[1 - parity][idx] = dp[1][1 - idx];

            ans = (ans + dp[1][idx]) % mod;
        }

        return ans;
    }
}