class Solution {
    public static int solve(int row, int col, int[][] dp, int n, int[][] mat) {
        if(row >= n || col >= n || col < 0) return (int) 1e9;
        if(row == n-1) return mat[row][col];
        if(dp[row][col] != -1) return dp[row][col]; 
        int bottom = mat[row][col] + solve(row + 1, col, dp, n, mat);
        int bLeft = mat[row][col] + solve(row + 1, col - 1, dp, n, mat);
        int bRight = mat[row][col] + solve(row + 1, col + 1, dp, n, mat);
        return dp[row][col] = Math.min(bottom, Math.min(bLeft, bRight));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++) dp[0][i] = matrix[0][i];
        int min = (int) 1e9;
        // for(int[] arr: dp) Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int bottom = Integer.MAX_VALUE;
                int bLeft = Integer.MAX_VALUE;
                int bRight = Integer.MAX_VALUE;

                if(j-1>=0) {
                    bLeft = matrix[i][j] + dp[i - 1][j-1];
                }

                bottom = matrix[i][j] + dp[i - 1][j];
                if(j+1 < n) {
                   bRight = matrix[i][j] + dp[i - 1][j+1];
               
                }
                dp[i][j] = Math.min(bottom, Math.min(bLeft, bRight));
            }
        }
        for(int i = 0; i<n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        for(int i = 0; i<n; i++) {
            min = Math.min(min, dp[n-1][i]);
        } 
        return min;
    }
}