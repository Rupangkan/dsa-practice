class Solution {
    static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] q) {
        List<Integer> b = new ArrayList<>();
        for (int p = 1; n > 0; p <<= 1, n >>= 1) if ((n & 1) == 1) b.add(p);
        int m = b.size();
        int[][] pre = new int[m][m];
        for (int i = 0; i < m; i++) {
            long v = 1;
            for (int j = i; j < m; j++) pre[i][j] = (int)(v = v * b.get(j) % MOD);
        }
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) res[i] = pre[q[i][0]][q[i][1]];
        return res;
    }
}