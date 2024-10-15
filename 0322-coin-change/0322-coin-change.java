class Solution {

    int solve(int t, int[] coins, int i) {
        if(i == coins.length) return (int)1e9;
        if(t == 0) return 0;

        int pick = (int)1e9;
        if(t>=coins[i])
            pick = 1+solve(t-coins[i], coins, i);
        int notPick = solve(t, coins, i+1);
        return Math.min(pick, notPick);
    }

    public int coinChange(int[] coins, int amount) {
        // int ans = solve(amount, coins, 0);
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i<=amount; i++) {
            for(int j = 0; j<n; j++) {
                int pick = amount+1;
                if(i - coins[j] >= 0) {
                    pick = 1 + dp[i-coins[j]];
                }
                dp[i] = Math.min(dp[i], pick);
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
        // if(ans == (int) 1e9) return -1;
        // return ans;
    }
}