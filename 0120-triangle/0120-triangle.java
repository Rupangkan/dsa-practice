class Solution {
    
    public static int solve(int row, int col, List<List<Integer>> t, int[][] dp, int n) {
        if(col >= t.get(row).size()) return (int) 1e9;
        if(row == n - 1) return t.get(row).get(col);
        if(dp[row][col] != -1) return dp[row][col];
        int down = t.get(row).get(col) + solve(row + 1, col, t, dp, n); 
        int bRight = t.get(row).get(col) + solve(row + 1, col + 1, t, dp, n);
        return dp[row][col] = Math.min(down, bRight);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        int n = triangle.size();
        // for(int[] arr: dp) Arrays.fill(arr, -1);
        // return solve(0, 0, triangle, dp, triangle.size());
        for(int i = 0; i<n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2; i>=0; i--) {
            for(int j = i; j>=0; j--) {
                int bottom = triangle.get(i).get(j) + dp[i+1][j];
                int bLeft = (int) 1e9;
                // if(j>0) {
                    bLeft = triangle.get(i).get(j) + dp[i+1][j+1];
                // }
                dp[i][j] = Math.min(bottom, bLeft);
            }
        }
        return dp[0][0];
    }
}