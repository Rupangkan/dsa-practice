class Solution {

    private long solve(int[] a, int k) {
        int n = a.length;
        long[][] dp = new long[n + 1][2];
        dp[n][1] = 0;
        dp[n][0] = Long.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int e = 0; e < 2; e++) {
                dp[i][e] = Math.max(dp[i + 1][e] + a[i], dp[i + 1][e ^ 1] + (a[i] ^ k));
            }
        }
        return dp[0][1];
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        return solve(nums, k);
    }
}