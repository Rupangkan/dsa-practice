class Solution {
    int[][] dp, left, right;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        left = new int[n][n];
        right = new int[n][n];

        for (int l = n - 1; l >= 0; l--) {
            left[l][l] = right[l][l] = stoneValue[l];
            int sum = stoneValue[l], leftSum = 0, p = l - 1;

            for (int r = l + 1; r < n; r++) {
                sum += stoneValue[r];

                while (p + 1 < r && (leftSum + stoneValue[p + 1]) * 2 <= sum) {
                    leftSum += stoneValue[++p];
                }

                if (p >= l)
                    dp[l][r] = Math.max(dp[l][r], left[l][p]);

                if (p + 1 < r)
                    dp[l][r] = Math.max(dp[l][r], right[p + 2][r]);

                if (leftSum * 2 == sum)
                    dp[l][r] = Math.max(dp[l][r], right[p + 1][r]);

                left[l][r] = Math.max(left[l][r - 1], sum + dp[l][r]);
                right[l][r] = Math.max(right[l + 1][r], sum + dp[l][r]);
            }
        }

        return dp[0][n - 1];
    }
}