class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i + 1][j + 1] = (s1.charAt(i) == s2.charAt(j))
                    ? dp[i][j] + s1.charAt(i)
                    : Math.max(dp[i][j + 1], dp[i + 1][j]);

        int sum = 0;
        for (char c : (s1 + s2).toCharArray()) sum += c;

        return sum - 2 * dp[n][m];
    }
}
