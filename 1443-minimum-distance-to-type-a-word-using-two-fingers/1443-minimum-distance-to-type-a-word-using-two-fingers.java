class Solution {

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][26][26];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }

        int first = word.charAt(0) - 'A';
        for (int i = 0; i < 26; i++) {
            dp[0][i][first] = 0;
            dp[0][first][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int pre = word.charAt(i - 1) - 'A';
            int d = dist(pre, cur);

            for (int j = 0; j < 26; j++) {
                dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][pre][j] + d);
                dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][pre] + d);

                if (j == pre) {
                    for (int k = 0; k < 26; k++) {
                        int dd = dist(k, cur);
                        dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][k][j] + dd);
                        dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][k] + dd);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans = Math.min(ans, dp[n - 1][i][j]);
            }
        }

        return ans;
    }
}