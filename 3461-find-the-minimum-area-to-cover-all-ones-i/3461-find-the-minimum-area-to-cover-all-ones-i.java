class Solution {
    public int minimumArea(int[][] g) {
        int n = g.length, m = g[0].length;
        int a = n, b = m, c = 0, d = 0;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (g[i][j] == 1) {
                    a = Math.min(a, i); c = Math.max(c, i);
                    b = Math.min(b, j); d = Math.max(d, j);
                }
        return (c - a + 1) * (d - b + 1);
    }
}