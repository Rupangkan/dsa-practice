class Solution {
    public int[] smallestSubarrays(int[] a) {
        int n = a.length;
        int[] p = new int[31], res = new int[n];
        Arrays.fill(p, -1);
        for (int i = n - 1; i >= 0; --i) {
            int j = i;
            for (int b = 0; b < 31; ++b) {
                if ((a[i] & (1 << b)) == 0) {
                    if (p[b] != -1) j = Math.max(j, p[b]);
                } else p[b] = i;
            }
            res[i] = j - i + 1;
        }
        return res;
    }
}