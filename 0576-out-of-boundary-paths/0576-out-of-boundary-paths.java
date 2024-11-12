class Solution {
    final int mod = 1000000007;
    int solve(int maxMove, int m, int n, int currRow, int currCol, int[][][] dp) {
        if(currRow >= m || currRow < 0 || currCol >= n || currCol < 0) return 1;
        // if(currCol >= n || currCol < 0) return 1;
        if(maxMove == 0) return 0;

        if(dp[currRow][currCol][maxMove] != -1) {
            return dp[currRow][currCol][maxMove];
        }

        int up = solve(maxMove - 1, m, n, currRow-1, currCol, dp);
        int down = solve(maxMove - 1, m, n, currRow+1, currCol, dp);
        int left = solve(maxMove - 1, m, n, currRow, currCol-1, dp);
        int right = solve(maxMove - 1, m, n, currRow, currCol+1, dp);

        return dp[currRow][currCol][maxMove] = ((up + down) % mod + (left + right) % mod) % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int[][] arr: dp) {
            for(int[] arr1: arr) {
                Arrays.fill(arr1, -1);
            }
        }
      
        int ans = solve(maxMove, m, n, startRow, startColumn, dp);
        return ans;
    }
}