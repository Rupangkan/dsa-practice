class Solution {
    public int[] successfulPairs(int[] s, int[] p, long x) {
        Arrays.sort(p);
        int n = s.length, res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = p.length - 1, id = p.length;
            while (l <= r) {
                int m = (l + r) >> 1;
                if ((long) s[i] * p[m] >= x) {
                    id = m;
                    r = m - 1;
                } else l = m + 1;
            }
            res[i] = p.length - id;
        }
        return res;
    }
}
