class Solution {
    public int maxSumDivThree(int[] a) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int x : a) {
            int[] ndp = dp.clone();
            int r = x % 3;
            for (int i = 0; i < 3; i++) {
                ndp[(i + r) % 3] = Math.max(ndp[(i + r) % 3], dp[i] + x);
            }
            dp = ndp;
        }
        return dp[0];
    }
}
