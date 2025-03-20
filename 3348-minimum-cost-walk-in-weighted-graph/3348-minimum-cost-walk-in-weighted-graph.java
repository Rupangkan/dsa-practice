class Solution {

    private int getC(int node, List<List<int[]>> adj, boolean[] vis, int[] comp, int id) {
        int cost = Integer.MAX_VALUE;
        vis[node] = true;
        comp[node] = id;
        
        for (int[] nb : adj.get(node)) {
            cost &= nb[1];
            if (!vis[nb[0]]) cost &= getC(nb[0], adj, vis, comp, id);
        }
        
        return cost;
    }   

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        boolean[] vis = new boolean[n];
        int[] comp = new int[n], ans = new int[query.length];
        List<Integer> cost = new ArrayList<>();
        int id = 0;

        for (int i = 0; i < n; i++) 
            if (!vis[i]) cost.add(getC(i, adj, vis, comp, id++));

        for (int i = 0; i < query.length; i++) 
            ans[i] = comp[query[i][0]] == comp[query[i][1]] ? cost.get(comp[query[i][0]]) : -1;

        return ans;
    }
}