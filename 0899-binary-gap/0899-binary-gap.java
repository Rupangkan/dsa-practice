class Solution {
    public int binaryGap(int n) {
        int prev = -1, res = 0;

        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                if (prev != -1) {
                    res = Math.max(res, i - prev);
                }
                prev = i;
            }
        }

        return res;
    }
}
