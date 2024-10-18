class Solution {

    boolean part(int idx, int[] nums, int target, int[][] dp) {
        if(idx == nums.length) return target == 0;
        if(target == 0) return true;
        if(dp[idx][target] != -1) return (dp[idx][target] == 0) ? false: true;

        boolean notTake = part(idx + 1, nums, target, dp);
        boolean take = false;
        if(target >= nums[idx]) {
            take = part(idx + 1, nums, target - nums[idx], dp);
        }
        dp[idx][target] = (take || notTake) == true ? 1: 0;
        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i = 0; i<n; i++) sum+=nums[i];
        boolean[][] dp = new boolean[n+1][sum/2+1];

        if(sum % 2 != 0) return false;

        dp[n][0] = true;

        for(int i = n-1; i>=0; i--) {
            dp[i][0] = true;
            for(int j = 1; j<=sum/2; j++) {
                boolean take = false;
                boolean notTake = dp[i+1][j];
                if(j >= nums[i]) {
                    take = dp[i+1][j-nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        return dp[0][sum/2];
    }
}