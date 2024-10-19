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
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solve(word1, word2, word1.length()-1, word2.length()-1, dp);
    }
}