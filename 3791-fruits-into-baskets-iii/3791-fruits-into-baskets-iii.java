class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = b.length, blk = (int) Math.sqrt(n), sec = (n + blk - 1) / blk;
        int[] mx = new int[sec];
        for (int i = 0; i < n; i++) mx[i / blk] = Math.max(mx[i / blk], b[i]);

        int res = 0;
        for (int x : f) {
            boolean placed = false;
            for (int s = 0; s < sec; s++) {
                if (mx[s] < x) continue;
                boolean done = false;
                mx[s] = 0;
                for (int i = 0; i < blk; i++) {
                    int idx = s * blk + i;
                    if (idx < n && b[idx] >= x && !done) {
                        b[idx] = 0;
                        done = true;
                    }
                    if (idx < n) mx[s] = Math.max(mx[s], b[idx]);
                }
                placed = true;
                break;
            }
            if (!placed) res++;
        }
        return res;
    }
}
