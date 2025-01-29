class Solution {
    int cycle = -1;

    void dfs(int node, int[] parent, boolean[] vis, List<Integer>[] adj) {
        vis[node] = true;
        for(int nei: adj[node]) {
            if(!vis[nei]) {
                parent[nei] = node;
                dfs(nei, parent, vis, adj);
            } else if(nei != parent[node] && cycle == -1) {
                cycle = nei;
                parent[nei] = node;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        Arrays.fill(parent, -1);

        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] e: edges) {
            adj[e[0] - 1].add(e[1] - 1);
            adj[e[1] - 1].add(e[0] - 1);
        }
        
        dfs(0, parent, vis, adj);
        Set<Integer> cycleSet = new HashSet<>();
        for (int node = cycle; cycleSet.add(node); node = parent[node]);
        for (int i = n - 1; i >= 0; i--) {
            if (cycleSet.contains(edges[i][0] - 1) && cycleSet.contains(edges[i][1] - 1)) {
                return edges[i];
            }
        }
        return new int[0];
    }
}