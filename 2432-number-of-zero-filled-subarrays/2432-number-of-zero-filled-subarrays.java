class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long c = 0, s = 0;
        for(int n: nums) {
            s = (n == 0) ? s + 1 : 0;
            c += s;
        }
        return c;
    }
}