class Solution {
    private int[] f(int x) {
        int[] r = new int[10];
        for (; x > 0; x /= 10) r[x % 10]++;
        return r;
    }
    private boolean eq(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) if (a[i] != b[i]) return false;
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        int[] t = f(n);
        for (int p = 1; p > 0; p <<= 1) if (eq(t, f(p))) return true;
        return false;
    }
}
