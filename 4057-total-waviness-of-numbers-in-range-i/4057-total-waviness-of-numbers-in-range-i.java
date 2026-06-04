class Solution {

    String s;
    int n;
    long[][][] cnt;
    long[][][] sum;

    public int totalWaviness(int num1, int num2) {
        return (int) (calc(num2) - calc(num1 - 1L));
    }

    long calc(long x) {
        if (x < 100) return 0;

        s = String.valueOf(x);
        n = s.length();

        cnt = new long[16][10][10];
        sum = new long[16][10][10];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(cnt[i][j], -1);
                Arrays.fill(sum[i][j], -1);
            }
        }

        return dfs(0, -1, -1, true, true)[1];
    }

    long[] dfs(int pos, int a, int b, boolean lim, boolean lead) {
        if (pos == n) return new long[] {1, 0};

        if (!lim && !lead && a >= 0 && b >= 0 && cnt[pos][a][b] != -1) {
            return new long[] {cnt[pos][a][b], sum[pos][a][b]};
        }

        long ways = 0, score = 0;
        int up = lim ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= up; d++) {
            boolean nl = lead && d == 0;

            int na = b;
            int nb = nl ? -1 : d;

            long[] cur = dfs(
                pos + 1,
                na,
                nb,
                lim && d == up,
                nl
            );

            long c = cur[0];
            long v = cur[1];

            if (!nl && a >= 0 && b >= 0) {
                if ((a < b && b > d) || (a > b && b < d)) {
                    score += c;
                }
            }

            ways += c;
            score += v;
        }

        if (!lim && !lead && a >= 0 && b >= 0) {
            cnt[pos][a][b] = ways;
            sum[pos][a][b] = score;
        }

        return new long[] {ways, score};
    }
}