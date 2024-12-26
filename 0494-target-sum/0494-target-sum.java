class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[][] dp = new int[n][2*sum+1];

        dp[0][nums[0] + sum]  = 1;
        dp[0][-nums[0] + sum] += 1;

        for(int i = 1; i<n; i++) {
            for(int j = -sum; j<=sum; j++) {
                if(dp[i-1][j+sum] > 0) {
                    dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
                    dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
                }
            }
        }

        return Math.abs(target) > sum ? 0 : dp[n-1][target + sum];
    }
}