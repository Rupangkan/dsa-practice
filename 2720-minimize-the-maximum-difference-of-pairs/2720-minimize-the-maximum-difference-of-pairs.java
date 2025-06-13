class Solution {
    private int pairs(int[] a, int d) {
        int i = 0, c = 0;
        while (i < a.length - 1) {
            if (a[i + 1] - a[i] <= d) {
                c++;
                i++;
            }
            i++;
        }
        return c;
    }

    private int solve(int[] a, int p) {
        Arrays.sort(a);
        int l = 0, r = a[a.length - 1] - a[0];
        while (l < r) {
            int m = (l + r) >>> 1;
            if (pairs(a, m) >= p) r = m;
            else l = m + 1;
        }
        return l;
    }

    public int minimizeMax(int[] nums, int p) {
        return solve(nums, p);
    }
}