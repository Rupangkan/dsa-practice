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
        int[][] dp = new int[n][(2*sum)+1];
        for(int[] arr: dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return solve(nums, 0, 0, target, sum, dp);
    }
}