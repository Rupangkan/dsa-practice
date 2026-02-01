class Solution {
    public int minimumCost(int[] a) {
        int x = 101, y = 101;
        for (int i = 1; i < a.length; i++) {
            int v = a[i];
            if (v < x) {
                y = x;
                x = v;
            } else if (v < y) {
                y = v;
            }
        }
        return a[0] + x + y;
    }
}
