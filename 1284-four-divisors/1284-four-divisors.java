class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            int v = calc(x);
            if (v != -1) ans += v;
        }
        return ans;
    }

    private int calc(int n) {
        int p = (int) Math.cbrt(n);
        if ((long) p * p * p == n && prime(p))
            return 1 + p + p * p + n;

        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                int a = i, b = n / i;
                if (a != b && prime(a) && prime(b))
                    return 1 + a + b + n;
                return -1;
            }
        }
        return -1;
    }

    private boolean prime(int x) {
        if (x < 2) return false;
        for (int i = 2; (long) i * i <= x; i++)
            if (x % i == 0) return false;
        return true;
    }
}
