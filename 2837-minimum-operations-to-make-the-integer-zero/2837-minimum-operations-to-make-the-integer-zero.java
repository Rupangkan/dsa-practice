class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; ; k++) {
            long v = num1 - 1L * num2 * k;
            if (v < k) return -1;
            if (Long.bitCount(v) <= k) return k;
        }
    }
}
