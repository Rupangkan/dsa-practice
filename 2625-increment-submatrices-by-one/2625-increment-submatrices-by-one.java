class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
        int[][] d = new int[n+1][n+1];
        for (int[] x : q) {
            int r1 = x[0], c1 = x[1], r2 = x[2], c2 = x[3];
            d[r1][c1]++;
            d[r2+1][c1]--;
            d[r1][c2+1]--;
            d[r2+1][c2+1]++;
        }

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = i > 0 ? a[i-1][j] : 0;
                int left = j > 0 ? a[i][j-1] : 0;
                int diag = (i > 0 && j > 0) ? a[i-1][j-1] : 0;
                a[i][j] = d[i][j] + up + left - diag;
            }
        }
        return a;
    }
}
