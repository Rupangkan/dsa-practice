class Solution {

    int dfs(int node, int parent, int time, int bob, int[] amount, List<List<Integer>> t, int n, int[] d) {
        d[node] = (node == bob) ? 0 : n;
        int maxChild = Integer.MIN_VALUE;
        for (int adj : t.get(node)) {
            if (adj != parent) {
                maxChild = Math.max(maxChild, dfs(adj, node, time + 1, bob, amount, t, n, d));
                d[node] = Math.min(d[node], d[adj] + 1);
            }
        }
        int income = d[node] > time ? amount[node] : d[node] == time ? amount[node] / 2 : 0;
        return income + (maxChild == Integer.MIN_VALUE ? 0 : maxChild);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> t = new ArrayList<>();
        int n = amount.length;
        int[] d = new int[n];

        for(int i = 0; i<n; i++) t.add(new ArrayList<>());

        for(int[] e: edges) {
            t.get(e[0]).add(e[1]);
            t.get(e[1]).add(e[0]);
        }

        return dfs(0, -1, 0, bob, amount, t, n, d);
    }
}