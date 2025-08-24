class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, left = 0, zeros = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > 1) {
                if (nums[left++] == 0) zeros--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}