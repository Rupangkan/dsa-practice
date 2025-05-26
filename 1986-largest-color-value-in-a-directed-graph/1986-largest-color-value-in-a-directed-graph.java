class Solution {
    private static final int INF = Integer.MAX_VALUE;

    private int solve(String s, int[][] e) {
        int n = s.length();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] x : e) g.get(x[0]).add(x[1]);

        int[][] cnt = new int[n][26];
        int[] vis = new int[n];
        int res = 0;

        for (int i = 0; i < n && res != INF; i++) {
            res = Math.max(res, go(i, s, g, cnt, vis));
        }
        return res == INF ? -1 : res;
    }

    private int go(int u, String s, List<List<Integer>> g, int[][] cnt, int[] vis) {
        if (vis[u] == 1) return INF;
        if (vis[u] == 2) return cnt[u][s.charAt(u) - 'a'];

        vis[u] = 1;
        for (int v : g.get(u)) {
            int r = go(v, s, g, cnt, vis);
            if (r == INF) return INF;
            for (int c = 0; c < 26; c++) cnt[u][c] = Math.max(cnt[u][c], cnt[v][c]);
        }
        cnt[u][s.charAt(u) - 'a']++;
        vis[u] = 2;
        return cnt[u][s.charAt(u) - 'a'];
    }

    public int largestPathValue(String s, int[][] e) {
        return solve(s, e);
    }
}