class Solution {

    int mod = 1_00_00_00_00_7;

    public int solve(int zero, int one, int len, int[] dp) {
        if(len == 0) return 1;
        if(len < 0) return 0;

        if(dp[len] != -1) return dp[len];

        return dp[len] = (solve(zero, one, len-zero, dp) + solve(zero, one, len-one, dp)) % mod;  

    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        int ans = 0;
        Arrays.fill(dp, -1);
        // for(int[] arr: dp) Arrays.fill(arr, -1);

        for(int i = low; i<=high; i++) {
            ans = (ans+solve(zero, one, i, dp))%mod;
        }
        return ans;
    }
}