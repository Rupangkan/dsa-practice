class Solution {
    public long putMarbles(int[] w, int k) {
        int n = w.length;
        int[] pw = new int[n-1];
        long res = 0L;

        for(int i = 0; i<n-1; i++) pw[i] = w[i] + w[i+1];
        Arrays.sort(pw, 0, n-1);

        for(int i = 0; i<k-1; i++) res += pw[n-2-i] - pw[i];

        return res;
    }
}