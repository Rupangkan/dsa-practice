class Solution {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2] << 1});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] used = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];

            if (used[u]) continue;
            if (u == n - 1) return d;

            used[u] = true;

            for (int[] v : adj[u]) {
                int nd = d + v[1];
                if (nd < dist[v[0]]) {
                    dist[v[0]] = nd;
                    pq.add(new int[]{nd, v[0]});
                }
            }
        }

        return -1;
    }
}
