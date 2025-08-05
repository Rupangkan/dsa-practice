class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int res = 0, n = b.length;
        for (int x : f) {
            boolean placed = false;
            for (int i = 0; i < n; i++) {
                if (x <= b[i]) {
                    b[i] = 0;
                    placed = true;
                    break;
                }
            }
            if (!placed) res++;
        }
        return res;
    }
}
