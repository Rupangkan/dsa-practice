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
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int i = n-1; i>=0; i--) {
            for(int j = i+1; j<n; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                } 
            }
          
        }
        int max = 0;
        for(int i = 0; i<dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}