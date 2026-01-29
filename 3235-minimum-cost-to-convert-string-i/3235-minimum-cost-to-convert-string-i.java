class Solution {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<int[]>[] g = new ArrayList[26];
        for (int i = 0; i < 26; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < original.length; i++)
            g[original[i] - 'a'].add(new int[]{changed[i] - 'a', cost[i]});

        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++)
            dist[i] = dijkstra(i, g);

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';
            if (a != b) {
                if (dist[a][b] < 0) return -1;
                ans += dist[a][b];
            }
        }
        return ans;
    }

    private long[] dijkstra(int s, List<int[]>[] g) {
        long[] d = new long[26];
        Arrays.fill(d, -1);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, s});
        d[s] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long w = cur[0];
            int u = (int) cur[1];
            if (d[u] != w) continue;

            for (int[] e : g[u]) {
                int v = e[0];
                long nw = w + e[1];
                if (d[v] == -1 || nw < d[v]) {
                    d[v] = nw;
                    pq.offer(new long[]{nw, v});
                }
            }
        }
        return d;
    }
}
