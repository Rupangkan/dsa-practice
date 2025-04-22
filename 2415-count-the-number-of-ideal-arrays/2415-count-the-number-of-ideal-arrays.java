class Solution {
    static final int MOD = (int) 1e9 + 7;
    static final int N = 10010, P = 15;
    static int[][] C = new int[N + P][P + 1];
    static int[] spf = new int[N];
    static List<Integer>[] primePowers = new ArrayList[N];

    public Solution() {
        if (C[0][0] == 1) return;

        for (int i = 0; i < N; i++) primePowers[i] = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (spf[i] == 0) {
                for (int j = i; j < N; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }

        for (int i = 2; i < N; i++) {
            int x = i;
            while (x > 1) {
                int p = spf[x], count = 0;
                while (x % p == 0) {
                    x /= p;
                    count++;
                }
                primePowers[i].add(count);
            }
        }

        C[0][0] = 1;
        for (int i = 1; i < N + P; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, P); j++) {
                C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            long cur = 1;
            for (int cnt : primePowers[i]) {
                cur = (cur * C[n + cnt - 1][cnt]) % MOD;
            }
            res = (res + cur) % MOD;
        }
        return (int) res;
    }
}