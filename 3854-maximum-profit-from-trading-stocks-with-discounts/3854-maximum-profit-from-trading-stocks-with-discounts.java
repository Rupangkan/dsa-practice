class Solution {

    static class R {
        int[] a, b;
        int sz;
        R(int[] a, int[] b, int sz) {
            this.a = a; this.b = b; this.sz = sz;
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : hierarchy) g[e[0] - 1].add(e[1] - 1);
        return dfs(0, g, present, future, budget).a[budget];
    }

    private R dfs(int u, List<Integer>[] g, int[] p, int[] f, int B) {
        int cost = p[u], half = cost / 2;
        int[] dp0 = new int[B + 1], dp1 = new int[B + 1];
        int[] c0 = new int[B + 1], c1 = new int[B + 1];
        int sz = cost;

        for (int v : g[u]) {
            R r = dfs(v, g, p, f, B);
            sz += r.sz;
            for (int i = B; i >= 0; i--) {
                for (int j = 0; j <= Math.min(r.sz, i); j++) {
                    c0[i] = Math.max(c0[i], c0[i - j] + r.a[j]);
                    c1[i] = Math.max(c1[i], c1[i - j] + r.b[j]);
                }
            }
        }

        for (int i = 0; i <= B; i++) {
            dp0[i] = c0[i];
            dp1[i] = c0[i];
            if (i >= half) dp1[i] = Math.max(dp1[i], c1[i - half] + f[u] - half);
            if (i >= cost) dp0[i] = Math.max(dp0[i], c1[i - cost] + f[u] - cost);
        }

        return new R(dp0, dp1, sz);
    }
}
