class Solution {
    int solve(int idx, int[] cost, int[] dp, int n) {
        if(idx >= n) return 0;
        
        if(dp[idx] != -1) return dp[idx];

        int pickOne = cost[idx] + solve(idx + 1, cost, dp, n);
        int pickTwo = cost[idx] + solve(idx + 2, cost, dp, n);

        return dp[idx] = Math.min(pickOne, pickTwo);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return Math.min(solve(0, cost, dp, n), solve(1, cost, dp, n));
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<n; i++) {
            int pickOne = cost[i] + dp[i-1];
            int pickTwo = cost[i] + dp[i-2];
            dp[i] = Math.min(pickOne, pickTwo);
        }
        // System.out.println(Arrays.toString(dp));
        return Math.min(dp[n-1], dp[n-2]);
    }
}