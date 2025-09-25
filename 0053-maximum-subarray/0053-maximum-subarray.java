class Solution {
    public int maxSubArray(int[] nums) {
        int maxCurr = nums[0];
        int max = nums[0];
        int n = nums.length;

        for(int i = 1; i<n; i++) {
            maxCurr = Math.max(nums[i], nums[i] + maxCurr);
            max = Math.max(max, maxCurr);
        }

        return max;
    }
}