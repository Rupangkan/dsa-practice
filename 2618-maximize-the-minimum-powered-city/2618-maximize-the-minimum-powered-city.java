class Solution {

    public long maxPower(int[] a, int r, int k) {
        int n = a.length;
        long[] pref = new long[n+1];
        
        for(int i=0;i<n;i++){
            int L = Math.max(0, i-r);
            int R = Math.min(n, i+r+1);
            pref[L] += a[i];
            pref[R] -= a[i];
        }

        long lo = (long)1e18, hi = 0;
        for(int x : a) lo = Math.min(lo, x);
        for(int x : a) hi += x;
        hi += k;

        long ans = 0;
        while(lo <= hi){
            long mid = (lo+hi)>>1;
            if(ok(pref, mid, r, k, n)){
                ans = mid;
                lo = mid+1;
            } else hi = mid-1;
        }
        return ans;
    }

    private boolean ok(long[] base, long need, int r, long k, int n){
        long[] cur = base.clone();
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += cur[i];
            if(sum < need){
                long add = need - sum;
                if(k < add) return false;
                k -= add;
                int R = Math.min(n, i + 2*r + 1);
                cur[R] -= add;
                sum += add;
            }
        }
        return true;
    }
}
