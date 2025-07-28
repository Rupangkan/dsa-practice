class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int mx = 0;
        int[] f = new int[1 << 17];
        f[0] = 1;
        for (int x : nums) {
            for (int i = mx; i >= 0; --i) {
                f[i | x] += f[i];
            }
            mx |= x;
        }
        return f[mx];
    }
}