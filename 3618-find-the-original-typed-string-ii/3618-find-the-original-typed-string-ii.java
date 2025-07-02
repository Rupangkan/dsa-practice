class Solution {
    private static final int MOD = 1_000_000_007;

    private int solve(String s, int k) {
        int n = s.length(), c = 1;
        List<Integer> seg = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) c++;
            else {
                seg.add(c);
                c = 1;
            }
        }
        seg.add(c);
        long ways = 1;
        for (int x : seg) ways = (ways * x) % MOD;
        if (seg.size() >= k) return (int) ways;

        int[] f = new int[k], g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);

        for (int x : seg) {
            int[] nf = new int[k];
            for (int j = 1; j < k; j++) {
                nf[j] = g[j - 1];
                if (j - x - 1 >= 0) {
                    nf[j] = (nf[j] - g[j - x - 1] + MOD) % MOD;
                }
            }
            int[] ng = new int[k];
            ng[0] = nf[0];
            for (int j = 1; j < k; j++) ng[j] = (ng[j - 1] + nf[j]) % MOD;
            f = nf;
            g = ng;
        }

        return (int) ((ways - g[k - 1] + MOD) % MOD);
    }

    public int possibleStringCount(String word, int k) {
        return solve(word, k);
    }
}