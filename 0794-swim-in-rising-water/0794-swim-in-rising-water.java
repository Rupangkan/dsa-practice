class Solution {
    public int swimInWater(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int lo = g[0][0], hi = 0;
        for (int[] r : g)
            for (int v : r)
                hi = Math.max(hi, v);
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (ok(g, mid, m, n, d)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    boolean ok(int[][] g, int t, int m, int n, int[][] d) {
        if (g[0][0] > t) return false;
        boolean[][] vis = new boolean[m][n];
        return dfs(g, 0, 0, t, vis, m, n, d);
    }

    boolean dfs(int[][] g, int r, int c, int t, boolean[][] vis, int m, int n, int[][] d) {
        if (r == m - 1 && c == n - 1) return true;
        vis[r][c] = true;
        for (int[] x : d) {
            int nr = r + x[0], nc = c + x[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc] && g[nr][nc] <= t)
                if (dfs(g, nr, nc, t, vis, m, n, d)) return true;
        }
        return false;
    }
}
