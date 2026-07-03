class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int lo = Integer.MAX_VALUE, hi = 0;

        for (int[] e : edges) {

            int u = e[0], v = e[1], w = e[2];

            if (!online[u] || !online[v]) {
                continue;
            }

            graph[u].add(new int[]{v, w});
            indegree[v]++;

            lo = Math.min(lo, w);
            hi = Math.max(hi, w);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int[] e : graph[u]) {
                int v = e[0];

                if (--indegree[v] == 0 && v != 0) {
                    q.offer(v);
                }
            }
        }

        if (!check(lo, k, graph, indegree, n)) {
            return -1;
        }

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (check(mid, k, graph, indegree, n)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    private boolean check(int limit, long k, List<int[]>[] graph, int[] indegree, int n) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 2);

        dist[0] = 0;

        int[] deg = indegree.clone();

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while (!q.isEmpty()) {

            int u = q.poll();

            if (u == n - 1) {
                return dist[u] <= k;
            }

            for (int[] e : graph[u]) {

                int v = e[0], w = e[1];

                if (w >= limit) {
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }

                if (--deg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return false;
    }
}