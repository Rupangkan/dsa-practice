class Solution {
    private int area(int[][] g, int u, int d, int l, int r) {
        int a = g.length, b = g[0].length, x = 0, y = 0;
        for (int i = u; i <= d; i++) 
            for (int j = l; j <= r; j++) 
                if (g[i][j] == 1) {
                    a = Math.min(a, i); b = Math.min(b, j);
                    x = Math.max(x, i); y = Math.max(y, j);
                }
        return a <= x ? (x - a + 1) * (y - b + 1) : 1 << 28;
    }

    private int[][] rot(int[][] v) {
        int n = v.length, m = v[0].length;
        int[][] t = new int[m][n];
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                t[m - j - 1][i] = v[i][j];
        return t;
    }

    private int go(int[][] g) {
        int n = g.length, m = g[0].length, res = n * m;
        for (int i = 0; i + 1 < n; i++) 
            for (int j = 0; j + 1 < m; j++) {
                res = Math.min(res, area(g, 0, i, 0, m - 1) + area(g, i + 1, n - 1, 0, j) + area(g, i + 1, n - 1, j + 1, m - 1));
                res = Math.min(res, area(g, 0, i, 0, j) + area(g, 0, i, j + 1, m - 1) + area(g, i + 1, n - 1, 0, m - 1));
            }
        for (int i = 0; i + 2 < n; i++) 
            for (int j = i + 1; j + 1 < n; j++) 
                res = Math.min(res, area(g, 0, i, 0, m - 1) + area(g, i + 1, j, 0, m - 1) + area(g, j + 1, n - 1, 0, m - 1));
        return res;
    }

    public int minimumSum(int[][] g) {
        return Math.min(go(g), go(rot(g)));
    }
}