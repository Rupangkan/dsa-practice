class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        List<Long> a = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (x == 0) a.add((long) y);
            else if (y == side) a.add(side + (long) x);
            else if (x == side) a.add(3L * side - y);
            else a.add(4L * side - x);
        }

        Collections.sort(a);

        long l = 1, r = side, ans = 0;

        while (l <= r) {
            long m = (l + r) >> 1;
            if (ok(a, side, k, m)) {
                ans = m;
                l = m + 1;
            } else r = m - 1;
        }

        return (int) ans;
    }

    private boolean ok(List<Long> a, int side, int k, long d) {
        long per = 4L * side;

        for (long s : a) {
            long lim = s + per - d;
            long cur = s;

            for (int i = 1; i < k; i++) {
                int idx = lb(a, cur + d);
                if (idx == a.size() || a.get(idx) > lim) {
                    cur = -1;
                    break;
                }
                cur = a.get(idx);
            }

            if (cur >= 0) return true;
        }

        return false;
    }

    private int lb(List<Long> a, long x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >> 1;
            if (a.get(m) < x) l = m + 1;
            else r = m;
        }
        return l;
    }
}