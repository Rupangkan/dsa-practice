class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long tot = 0;
        for (int x : batteries) tot += x;

        long lo = 1, hi = tot / n;
        while (lo < hi) {
            long mid = (lo + hi + 1) >> 1;
            long cnt = 0;

            for (int x : batteries) {
                cnt += Math.min((long)x, mid);
            }

            if (cnt >= mid * n) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
