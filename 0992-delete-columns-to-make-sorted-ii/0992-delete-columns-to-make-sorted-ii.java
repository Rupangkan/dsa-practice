class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length, m = a[0].length();
        boolean[] ok = new boolean[n - 1];
        int res = 0;

        for (int j = 0; j < m; j++) {
            boolean bad = false;
            for (int i = 0; i + 1 < n; i++) {
                if (!ok[i] && a[i].charAt(j) > a[i + 1].charAt(j)) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                res++;
                continue;
            }
            for (int i = 0; i + 1 < n; i++) {
                if (a[i].charAt(j) < a[i + 1].charAt(j)) ok[i] = true;
            }
        }
        return res;
    }
}
