class Solution {
    private int paths(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != Integer.MIN_VALUE) return dp[m][n];

        return dp[m][n] = paths(m-1, n, dp) + paths(m, n-1, dp); 
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return paths(m-1, n-1, dp);
    }
}