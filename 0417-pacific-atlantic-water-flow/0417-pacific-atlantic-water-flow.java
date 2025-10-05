class Solution {
    int m, n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        m = h.length; n = h[0].length;
        boolean[][] p = new boolean[m][n], a = new boolean[m][n];
        for (int j = 0; j < n; j++) dfs(0, j, h, p);
        for (int i = 0; i < m; i++) dfs(i, 0, h, p);
        for (int j = 0; j < n; j++) dfs(m - 1, j, h, a);
        for (int i = 0; i < m; i++) dfs(i, n - 1, h, a);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (p[i][j] && a[i][j]) ans.add(List.of(i, j));
        return ans;
    }
    
    void dfs(int i, int j, int[][] h, boolean[][] vis) {
        if (vis[i][j]) return;
        vis[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= n || h[x][y] < h[i][j]) continue;
            dfs(x, y, h, vis);
        }
    }
}
