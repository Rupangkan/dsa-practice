class Solution {

    private int solve(int[] e, int a, int b) {
        int n = e.length;
        int[] d1 = new int[n], d2 = new int[n];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        d1[a] = 0;
        d2[b] = 0;
        dfs(a, e, d1, new boolean[n]);
        dfs(b, e, d2, new boolean[n]);
        int res = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int mx = Math.max(d1[i], d2[i]);
            if (mx < min) {
                min = mx;
                res = i;
            }
        }
        return res;
    }

    private void dfs(int u, int[] e, int[] d, boolean[] vis) {
        vis[u] = true;
        int v = e[u];
        if (v != -1 && !vis[v]) {
            d[v] = d[u] + 1;
            dfs(v, e, d, vis);
        }
    }
    public int closestMeetingNode(int[] edges, int u, int v) {
        return solve(edges, u, v);
    }
}