class Solution {
    public int minimumOperations(int[] a) {
        int res = 0;
        for (int x : a) {
            int r = x % 3;
            res += Math.min(r, 3 - r);
        }
        return res;
    }
}
