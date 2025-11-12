class Solution {
    public int minOperations(int[] a) {
        int n = a.length, ones = 0, g = 0;
        for (int x : a) {
            if (x == 1) ones++;
            g = gcd(g, x);
        }
        if (ones > 0) return n - ones;
        if (g > 1) return -1;

        int best = n;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur = gcd(cur, a[j]);
                if (cur == 1) {
                    best = Math.min(best, j - i + 1);
                    break;
                }
            }
        }
        return best + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
