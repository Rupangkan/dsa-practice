class Solution {

    static class LCA {

        int n, LOG;
        int[] depth;
        int[][] up;
        List<Integer>[] graph;

        LCA(int[][] edges, int root) {

            n = edges.length + 1;
            LOG = 1;

            while ((1 << LOG) <= n) LOG++;

            depth = new int[n + 1];
            up = new int[n + 1][LOG];
            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }

            dfs(root, 0);

            for (int j = 1; j < LOG; j++) {
                for (int i = 1; i <= n; i++) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }

        void dfs(int node, int par) {

            up[node][0] = par;

            for (int nxt : graph[node]) {
                if (nxt == par) continue;

                depth[nxt] = depth[node] + 1;
                dfs(nxt, node);
            }
        }


        int lca(int a, int b) {

            if (depth[a] < depth[b]) {
                int t = a;
                a = b;
                b = t;
            }

            for (int i = LOG - 1; i >= 0; i--) {
                if (depth[up[a][i]] >= depth[b]) {
                    a = up[a][i];
                }
            }

            if (a == b) return a;


            for (int i = LOG - 1; i >= 0; i--) {
                if (up[a][i] != up[b][i]) {
                    a = up[a][i];
                    b = up[b][i];
                }
            }

            return up[a][0];
        }


        int dist(int a, int b) {
            int l = lca(a, b);
            return depth[a] + depth[b] - 2 * depth[l];
        }
    }


    static final int MOD = 1_000_000_007;
    static final int MAX = 100010;

    static int[] pow2 = new int[MAX];

    static {
        pow2[0] = 1;

        for (int i = 1; i < MAX; i++) {
            pow2[i] = (int)((long)pow2[i - 1] * 2 % MOD);
        }
    }


    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        LCA tree = new LCA(edges, 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u != v) {
                ans[i] = pow2[tree.dist(u, v) - 1];
            }
        }

        return ans;
    }
}