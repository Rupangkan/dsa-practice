class Solution {
    
    private int calc(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    private void dfs(int u, int p, int[] val, List<List<Integer>> g, int[] sum, int[] in, int[] out, int[] t) {
        in[u] = t[0]++;
        sum[u] = val[u];
        for (int v : g.get(u)) {
            if (v == p) continue;
            dfs(v, u, val, g, sum, in, out, t);
            sum[u] ^= sum[v];
        }
        out[u] = t[0];
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int[] sum = new int[n], in = new int[n], out = new int[n], time = {0};
        dfs(0, -1, nums, g, sum, in, out, time);

        int ans = Integer.MAX_VALUE;
        for (int u = 1; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (in[v] > in[u] && in[v] < out[u]) {
                    ans = Math.min(ans, calc(sum[0] ^ sum[u], sum[u] ^ sum[v], sum[v]));
                } else if (in[u] > in[v] && in[u] < out[v]) {
                    ans = Math.min(ans, calc(sum[0] ^ sum[v], sum[v] ^ sum[u], sum[u]));
                } else {
                    ans = Math.min(ans, calc(sum[0] ^ sum[u] ^ sum[v], sum[u], sum[v]));
                }
            }
        }
        return ans;
    }
}