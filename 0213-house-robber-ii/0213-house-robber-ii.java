class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n+1];
        int[] dp2 = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 1; i<n-1; i++) {
            int val = nums[i];
            dp[i+1] = Math.max(dp[i], dp[i-1] + val);
        }
        System.out.println(Arrays.toString(dp));
        
        dp2[1] = 0;
        dp2[2] = nums[1];

        for(int i = 2; i<n; i++) {
            int val = nums[i];
            dp2[i+1] = Math.max(dp2[i], dp2[i-1] + val);
        }
        System.out.println(Arrays.toString(dp2));
        return Math.max(dp[n-1], dp2[n]);
    }
}