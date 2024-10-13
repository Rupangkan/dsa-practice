class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = nums[n-1];
        
        for(int i = n-2; i>=0; i--) {
            int val = nums[i];
            dp[i] = Math.max(dp[i+1], dp[i+2] + val);
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}