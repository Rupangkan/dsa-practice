class Solution {
    public long maxProfit(int[] p, int[] s, int k) {
        int n = p.length;
        long[] a = new long[n+1], b = new long[n+1];
        for(int i=0;i<n;i++){
            a[i+1] = a[i] + 1L*p[i]*s[i];
            b[i+1] = b[i] + p[i];
        }
        long ans = a[n];
        int half = k>>1;
        for(int i=k-1;i<n;i++){
            long L = a[i-k+1];
            long R = a[n] - a[i+1];
            long mid = b[i+1] - b[i-half+1];
            ans = Math.max(ans, L + mid + R);
        }
        return ans;
    }
}
