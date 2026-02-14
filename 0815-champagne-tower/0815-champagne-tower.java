class Solution {
    public double champagneTower(int poured, int row, int glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                double overflow = (dp[i][j] - 1.0) / 2.0;
                if (overflow > 0) {
                    dp[i + 1][j] += overflow;
                    dp[i + 1][j + 1] += overflow;
                }
            }
        }

        return Math.min(1.0, dp[row][glass]);
    }
}
