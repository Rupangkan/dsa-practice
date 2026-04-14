class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        List<Integer> fpos = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                fpos.add(f[0]);
            }
        }

        int n = robot.size(), m = fpos.size();
        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i < n; i++) dp[i][m] = (long) 1e12;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                long take = Math.abs(robot.get(i) - fpos.get(j)) + dp[i + 1][j + 1];
                long skip = dp[i][j + 1];
                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[0][0];
    }
}