class Solution {
    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length(), mod = 1000000007;
        int[][] freq =  new int[n][26];
        long[][] dp = new long[n+1][m+1];

        for(String word: words) {
            for(int j = 0; j<n; j++) {
                freq[j][word.charAt(j)-'a']++;
            }
        }

        for(int i = 0; i<=n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                dp[i][j] = dp[i-1][j];

                int currPos = target.charAt(j-1)-'a';
                dp[i][j] += (freq[i-1][currPos] * dp[i-1][j-1]) % mod;
                dp[i][j] %= mod;
            }
        }

        return (int) dp[n][m];

    }
}