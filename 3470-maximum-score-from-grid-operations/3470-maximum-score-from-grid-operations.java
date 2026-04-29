class Solution {

    public long maximumScore(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) return 0;

        long[][][] dp = new long[n][n + 1][n + 1];
        long[][] pm = new long[n + 1][n + 1];
        long[][] sm = new long[n + 1][n + 1];
        long[][] pref = new long[n][n + 1];

        for (int c = 0; c < n; c++) {
            for (int r = 1; r <= n; r++) {
                pref[c][r] = pref[c][r - 1] + grid[r - 1][c];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int ch = 0; ch <= n; ch++) {
                for (int ph = 0; ph <= n; ph++) {

                    if (ch <= ph) {
                        long add = pref[i][ph] - pref[i][ch];
                        dp[i][ch][ph] = Math.max(dp[i][ch][ph], sm[ph][0] + add);
                    } else {
                        long add = pref[i - 1][ch] - pref[i - 1][ph];
                        dp[i][ch][ph] = Math.max(
                                dp[i][ch][ph],
                                Math.max(sm[ph][ch], pm[ph][ch] + add)
                        );
                    }
                }
            }

            for (int ch = 0; ch <= n; ch++) {
                pm[ch][0] = dp[i][ch][0];
                for (int ph = 1; ph <= n; ph++) {
                    long pen = ph > ch ? pref[i][ph] - pref[i][ch] : 0;
                    pm[ch][ph] = Math.max(pm[ch][ph - 1], dp[i][ch][ph] - pen);
                }

                sm[ch][n] = dp[i][ch][n];
                for (int ph = n - 1; ph >= 0; ph--) {
                    sm[ch][ph] = Math.max(sm[ch][ph + 1], dp[i][ch][ph]);
                }
            }
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[n - 1][n][k], dp[n - 1][0][k]));
        }

        return ans;
    }
}