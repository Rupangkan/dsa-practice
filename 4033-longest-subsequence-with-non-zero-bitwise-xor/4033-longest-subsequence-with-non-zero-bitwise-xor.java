class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZero = true;

        for (int x : nums) {
            xor ^= x;
            if (x != 0) allZero = false;
        }

        if (xor != 0) return nums.length;
        return allZero ? 0 : nums.length - 1;
    }
}