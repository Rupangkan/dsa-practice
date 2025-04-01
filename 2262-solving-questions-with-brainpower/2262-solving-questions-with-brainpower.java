class Solution {
    long ans(int i, long[] dp, int[][] q, int n) {
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        long take = q[i][0] + ans(i+q[i][1] + 1, dp, q, n);
        long no = ans(i+1, dp, q, n);

        return dp[i] = Math.max(take, no);
    }

    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return ans(0, dp, q, n);
    }
}