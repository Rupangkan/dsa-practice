class Solution {
    public double separateSquares(int[][] squares) {
        double hi = 0, total = 0;
        for (int[] s : squares) {
            total += 1.0 * s[2] * s[2];
            hi = Math.max(hi, s[1] + s[2]);
        }

        double lo = 0, eps = 1e-5;
        while (hi - lo > eps) {
            double mid = (lo + hi) / 2;
            if (ok(mid, squares, total)) hi = mid;
            else lo = mid;
        }
        return hi;
    }

    boolean ok(double y, int[][] sq, double total) {
        double area = 0;
        for (int[] s : sq) {
            if (s[1] < y)
                area += s[2] * Math.min(y - s[1], s[2]);
        }
        return area * 2 >= total;
    }
}
