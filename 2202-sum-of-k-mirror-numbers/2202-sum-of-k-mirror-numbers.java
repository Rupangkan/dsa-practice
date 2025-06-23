class Solution {
    private int[] base = new int[100];

    private boolean check(long val, int b) {
        int len = 0;
        while (val > 0) {
            base[len++] = (int)(val % b);
            val /= b;
        }
        for (int i = 0; i < len / 2; i++) {
            if (base[i] != base[len - 1 - i]) return false;
        }
        return true;
    }

    private long solve(int k, int n) {
        long sum = 0;
        int l = 1, c = 0;
        while (c < n) {
            int r = l * 10;
            for (int t = 0; t < 2 && c < n; t++) {
                for (int i = l; i < r && c < n; i++) {
                    long x = i, y = t == 0 ? i / 10 : i;
                    while (y > 0) {
                        x = x * 10 + y % 10;
                        y /= 10;
                    }
                    if (check(x, k)) {
                        sum += x;
                        c++;
                    }
                }
            }
            l = r;
        }
        return sum;
    }

    public long kMirror(int k, int n) {
        return solve(k, n);
    }
}