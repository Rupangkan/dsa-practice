class Solution {
    int solve(int[] nums, int idx, int t, int target, int sum, int[][] dp) {
        if(idx == nums.length) {
            if(t == target) return 1;
            else return 0;
        }
        if(dp[idx][t+sum] != Integer.MIN_VALUE) return dp[idx][t+sum];
        // if(t < 0 || t > target) return 0;
        if(idx >= nums.length) return 0;
        int add = solve(nums, idx+1, t-nums[idx], target, sum, dp);
        int neg = solve(nums, idx+1, t+nums[idx], target, sum, dp);

        return dp[idx][t+sum] = add+neg;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[n+1][(2*sum)+1];
        dp[0][sum+nums[0]] = 1;
        dp[0][sum-nums[0]] += 1;
        // for(int[] arr: dp) Arrays.fill(arr, Integer.MIN_VALUE);
        // return solve(nums, 0, 0, target, sum, dp);
        for(int i = 1; i<n; i++)  {
            for(int j = -sum; j<=sum; j++) {
                if(dp[i-1][sum + j] > 0) {
                    dp[i][j + nums[i] + sum] += dp[i-1][j+sum];
                    dp[i][j - nums[i] + sum] += dp[i-1][j+sum];
                }
            }
        }
        return Math.abs(target) > sum ? 0 : dp[n-1][target+sum];
    }
}