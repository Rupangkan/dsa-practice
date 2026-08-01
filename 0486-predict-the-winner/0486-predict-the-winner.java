class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) return true;

        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(0, n - 1, nums, dp) >= 0;
    }

    private int dfs(int l, int r, int[] nums, int[][] dp) {
        if (l == r) return nums[l];
        if (dp[l][r] != -1) return dp[l][r];

        return dp[l][r] = Math.max(
            nums[l] - dfs(l + 1, r, nums, dp),
            nums[r] - dfs(l, r - 1, nums, dp)
        );
    }
}