class Solution {
    public long minTime(int[] s, int[] m) {
        int n = s.length;
        long[] t = new long[n];
        for (int x : m) {
            long cur = 0;
            for (int i = 0; i < n; i++)
                cur = Math.max(cur, t[i]) + (long) s[i] * x;
            t[n - 1] = cur;
            for (int i = n - 2; i >= 0; i--)
                t[i] = t[i + 1] - (long) s[i + 1] * x;
        }
        return t[n - 1];
    }
}
