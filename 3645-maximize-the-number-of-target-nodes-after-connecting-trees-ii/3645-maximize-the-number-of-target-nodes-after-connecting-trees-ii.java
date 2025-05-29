class Solution {

    private int[] solve(int[][] a, int[][] b) {
        int n = a.length + 1, m = b.length + 1;
        int[] col1 = new int[n], col2 = new int[m];
        int[] cnt1 = calc(a, col1), cnt2 = calc(b, col2);
        int[] res = new int[n];
        int mx = Math.max(cnt2[0], cnt2[1]);
        for (int i = 0; i < n; i++) res[i] = cnt1[col1[i]] + mx;
        return res;
    }

    private int[] calc(int[][] e, int[] col) {
        int n = e.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] x : e) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        int a = dfs(0, -1, 0, g, col);
        return new int[] { a, n - a };
    }

    private int dfs(int u, int p, int d, List<List<Integer>> g, int[] col) {
        col[u] = d % 2;
        int r = (d % 2 == 0 ? 1 : 0);
        for (int v : g.get(u)) if (v != p) r += dfs(v, u, d + 1, g, col);
        return r;
    }

    public int[] maxTargetNodes(int[][] e1, int[][] e2) {
        return solve(e1, e2);
    }
}