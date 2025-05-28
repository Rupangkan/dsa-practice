class Solution {
    
    private int[] solve(int[][] a, int[][] b, int k) {
        int n = a.length + 1;
        int[] c1 = build(a, k);
        int[] c2 = build(b, k - 1);
        int mx = 0;
        for (int x : c2) mx = Math.max(mx, x);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = c1[i] + mx;
        return res;
    }

    private int[] build(int[][] e, int k) {
        int n = e.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] x : e) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = dfs(i, -1, g, k);
        return ans;
    }

    private int dfs(int u, int p, List<List<Integer>> g, int k) {
        if (k < 0) return 0;
        int r = 1;
        for (int v : g.get(u)) if (v != p) r += dfs(v, u, g, k - 1);
        return r;
    }

    public int[] maxTargetNodes(int[][] a, int[][] b, int k) {
        return solve(a, b, k);
    }
}