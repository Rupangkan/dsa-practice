class Solution {
    public int maximumInvitations(int[] fav) {
        int n = fav.length, lc = 0, two = 0;
        int[] in = new int[n], d = new int[n];
        Arrays.fill(d, 1);

        for (int p = 0; p < n; ++p) in[fav[p]]++;

        Queue<Integer> q = new LinkedList<>();
        for (int p = 0; p < n; ++p) 
            if (in[p] == 0) q.offer(p);

        while (!q.isEmpty()) {
            int u = q.poll(), v = fav[u];
            d[v] = Math.max(d[v], d[u] + 1);
            if (--in[v] == 0) q.offer(v);
        }

        for (int p = 0; p < n; ++p) {
            if (in[p] == 0) continue;
            int len = 0, cur = p;
            while (in[cur] != 0) {
                in[cur] = 0;
                len++;
                cur = fav[cur];
            }
            if (len == 2) 
                two += d[p] + d[fav[p]];
            else 
                lc = Math.max(lc, len);
        }

        return Math.max(lc, two);
    }
}