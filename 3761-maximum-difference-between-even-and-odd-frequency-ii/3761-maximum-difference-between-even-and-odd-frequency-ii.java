class Solution {
    private int getState(int a, int b) {
        return ((a & 1) << 1) | (b & 1);
    }

    private int solve(String s, int k) {
        int n = s.length(), res = Integer.MIN_VALUE;
        for (char x = '0'; x <= '4'; x++) {
            for (char y = '0'; y <= '4'; y++) {
                if (x == y) continue;
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int la = 0, lb = 0, ra = 0, rb = 0, l = -1;
                for (int r = 0; r < n; r++) {
                    ra += s.charAt(r) == x ? 1 : 0;
                    rb += s.charAt(r) == y ? 1 : 0;
                    while (r - l >= k && rb - lb >= 2) {
                        best[getState(la, lb)] = Math.min(best[getState(la, lb)], la - lb);
                        l++;
                        la += s.charAt(l) == x ? 1 : 0;
                        lb += s.charAt(l) == y ? 1 : 0;
                    }
                    int req = getState(ra, rb) ^ 2;
                    if (best[req] != Integer.MAX_VALUE) {
                        res = Math.max(res, ra - rb - best[req]);
                    }
                }
            }
        }
        return res;
    }

    public int maxDifference(String s, int k) {
        return solve(s, k);
    }
}