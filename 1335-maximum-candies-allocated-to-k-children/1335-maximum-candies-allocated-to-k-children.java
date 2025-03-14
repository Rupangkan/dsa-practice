class Solution {

    boolean allocate(int[] c, long k, int n) {
        long max = 0;
        for(int i = 0; i<c.length; i++) {
            max += c[i]/n;
        }
        return max >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int max = 0, l = 0, r = 0; 

        for(int i = 0; i<candies.length; i++) max = Math.max(max, candies[i]);

        r = max;

        while(l<r) {
            int mid = (l + r + 1)/2;

            if(allocate(candies, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}