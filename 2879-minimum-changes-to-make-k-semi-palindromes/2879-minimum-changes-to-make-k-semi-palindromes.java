class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length(), inf = Integer.MAX_VALUE / 2;
        int[][] cost = new int[n + 1][n + 1];

        for (int[] row : cost)
            Arrays.fill(row, inf);

        for (int d = 1; 2 * d <= n; d++) {
            for (int len = 2 * d; len <= n; len += d) {
                for (int i = 0, j = len; j <= n; i++, j++)
                    cost[i][j] = Math.min(cost[i][j], peel(s, i, j, d));
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        for (int pieces = 1; pieces < k; pieces++) {
            int[] next = new int[n + 1];
            Arrays.fill(next, inf);

            for (int j = 2 * pieces; j <= n - 2 * (k - pieces); j++)
                next[j] = extend(dp, cost, j);

            dp = next;
        }

        return extend(dp, cost, n);
    }

    private int peel(String s, int i, int j, int d) {
        int changes = 0;

        while (j - i > d) {
            for (int t = 0; t < d; t++) {
                if (s.charAt(i + t) != s.charAt(j - d + t))
                    changes++;
            }
            i += d;
            j -= d;
        }

        return changes;
    }

    private int extend(int[] dp, int[][] cost, int j) {
        int res = Integer.MAX_VALUE / 2;

        for (int i = 0; i <= j - 2; i++)
            res = Math.min(res, dp[i] + cost[i][j]);

        return res;
    }
}