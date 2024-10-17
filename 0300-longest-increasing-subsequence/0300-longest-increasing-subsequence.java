class Solution {
    int solve(int idx, int[] nums, int count, int prevInd, int[][] dp) {
        if(idx < 0) return 0;
        int pick = 0;
        if(dp[prevInd+1][idx] != -1) return dp[prevInd+1][idx];
        if(prevInd == -1 || nums[prevInd] > nums[idx]) {
            pick = 1+solve(idx - 1, nums, count+1, idx, dp);
        }
        int notPick = solve(idx-1, nums, count, prevInd, dp);
        return dp[prevInd+1][idx] = Math.max(pick, notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solve(nums.length-1, nums, 0, -1, dp);
    }
}