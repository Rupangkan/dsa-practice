class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int m = o.length;
        int n = o[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        if(o[m-1][n-1] == 1) return 0;
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) continue;
                int right = 0;
                int low = 0;
                if(o[i][j] == 1) {
                    dp[i][j] = 0;
        
                } else {
                    if(i+1<m) {
                        right = dp[i+1][j];
                    }
                    if(j+1<n) {
                        low = dp[i][j+1];
                    }
                    dp[i][j] = low + right;
                }
          
            }
        }
        for(int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][0];
    }
}