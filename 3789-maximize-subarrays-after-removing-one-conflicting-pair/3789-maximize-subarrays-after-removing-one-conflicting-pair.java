class Solution {
    public long maxSubarrays(int n, int[][] pairs) {
        int[] m1 = new int[n + 1], m2 = new int[n + 1];
        Arrays.fill(m1, Integer.MAX_VALUE);
        Arrays.fill(m2, Integer.MAX_VALUE);
        for (int[] p : pairs) {
            int u = Math.min(p[0], p[1]);
            int v = Math.max(p[0], p[1]);
            if (m1[u] > v) {
                m2[u] = m1[u];
                m1[u] = v;
            } else if (m2[u] > v) {
                m2[u] = v;
            }
        }
        long res = 0;
        int x = n, y = Integer.MAX_VALUE;
        long[] del = new long[n + 1];
        for (int i = n; i >= 1; i--) {
            if (m1[x] > m1[i]) {
                y = Math.min(y, m1[x]);
                x = i;
            } else {
                y = Math.min(y, m1[i]);
            }
            res += Math.min(m1[x], n + 1) - i;
            del[x] += Math.min(Math.min(y, m2[x]), n + 1) - Math.min(m1[x], n + 1);
        }
        long ans = 0;
        for (long d : del) ans = Math.max(ans, d);
        return res + ans;
    }
}