class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] dp = new int[k+1][n];

        for(int i = 0; i<k; i++) {
            for(int u = 0; u<n; u++) {
                for(int v = 0; v<n; v++) {
                    if(u == v) {
                        dp[i+1][v] = Math.max(dp[i+1][v], dp[i][u] + stayScore[i][v]);
                    } else {
                        dp[i+1][v] = Math.max(dp[i+1][v], dp[i][u] + travelScore[u][v]);
                    }
                    // dp[i][v] = Math.max(stayScore[i][v], dp[i][u] + travelScore[u][v]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i<=k; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print(dp[i][j] + " ");
                max = Math.max(max, dp[i][j]);
            }
            System.out.println();
        }
        return max;
    }
}