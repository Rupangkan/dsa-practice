class Solution {
    public boolean kLengthApart(int[] a, int k) {
        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                if (last != -1 && i - last - 1 < k) return false;
                last = i;
            }
        }
        return true;
    }
}
