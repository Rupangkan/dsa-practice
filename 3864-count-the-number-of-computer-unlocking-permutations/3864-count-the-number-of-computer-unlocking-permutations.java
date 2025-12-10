class Solution {

    public int countPermutations(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[0]) return 0;
        }
        long mod = 1_000_000_007L, res = 1;
        for (int i = 2; i < n; i++) res = (res * i) % mod;
        return (int) res;
    }
}
