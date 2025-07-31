class Solution {
    public int longestSubarray(int[] a) {
        int max = 0, res = 0, cnt = 0;
        for (int x : a) {
            if (x > max) {
                max = x;
                cnt = res = 0;
            }
            cnt = (x == max) ? cnt + 1 : 0;
            res = Math.max(res, cnt);
        }
        return res;
    }
}