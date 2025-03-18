class Solution {
    public int longestNiceSubarray(int[] nums) {
        int s = 0, max = 0, b = 0;

        for(int i = 0; i<nums.length; i++) {
            while((b & nums[i]) != 0) {
                b ^= nums[s];
                s++;
            }
            b |= nums[i];
            max = Math.max(max, i - s + 1);
        }

        return max;
    }
}