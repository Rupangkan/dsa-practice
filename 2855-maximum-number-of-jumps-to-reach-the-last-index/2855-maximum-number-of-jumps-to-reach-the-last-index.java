class Solution {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -(int)1e9);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                if (d < 0) d = -d;

                if (d <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] < 0 ? -1 : dp[n - 1];
    }
}