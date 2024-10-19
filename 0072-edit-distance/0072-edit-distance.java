class Solution {
    int solve(String w1, String w2, int i, int j, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j)) return dp[i][j] = solve(w1, w2, i-1, j-1, dp);

        int insert = 1 + solve(w1, w2, i, j-1, dp);
        int delete = 1 + solve(w1, w2, i-1, j, dp);
        int replace = 1 + solve(w1, w2, i-1, j-1, dp);

        return dp[i][j] = Math.min(replace, Math.min(delete, insert));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // return solve(word1, word2, word1.length()-1, word2.length()-1, dp);
        for(int i = 0; i<=n; i++) dp[i][0] = i;
        for(int j = 0; j<=m; j++) dp[0][j] = j;

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j]; 
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }

            }
        }

        return dp[n][m];
    }
}