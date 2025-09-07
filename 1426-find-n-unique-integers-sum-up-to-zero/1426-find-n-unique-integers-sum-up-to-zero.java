class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        for (int i = 0, v = 1; v <= n / 2; v++) {
            a[i++] = v;
            a[i++] = -v;
        }
        if ((n & 1) == 1) a[n - 1] = 0;
        return a;
    }
}
