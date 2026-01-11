class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = matrix[i][j] - '0';

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                if (a[i][j] == 1) a[i][j] += a[i][j - 1];

        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int w = a[i][j];
                if (w == 0) continue;

                int cur = w;
                for (int k = i; k < m && a[k][j] > 0; k++) {
                    cur = Math.min(cur, a[k][j]);
                    ans = Math.max(ans, cur * (k - i + 1));
                }

                cur = w;
                for (int k = i; k >= 0 && a[k][j] > 0; k--) {
                    cur = Math.min(cur, a[k][j]);
                    ans = Math.max(ans, cur * (i - k + 1));
                }
            }
        }
        return ans;
    }
}
