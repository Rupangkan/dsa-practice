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
        dp[0] = 1;
        for(int i = 1; i<=high; i++) {
            int len = i;
            int addZero = len - zero;
            int addOne = len - one;
            if(addZero >=0) {
                dp[i] = (dp[i] + dp[addZero])%mod;
            }
            if(addOne >= 0) {
                dp[i] = (dp[i] + dp[addOne])%mod;
            }
        }

        for(int i = low; i<=high; i++) {
            ans = (ans + dp[i])%mod;
        }
        return ans;
    }
}