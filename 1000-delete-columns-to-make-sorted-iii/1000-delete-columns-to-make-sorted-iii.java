class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length, m = a[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                boolean ok = true;
                for (int r = 0; r < n; r++) {
                    if (a[r].charAt(i) > a[r].charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        int best = 0;
        for (int x : dp) best = Math.max(best, x);
        return m - best;
    }
}
