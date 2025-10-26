class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxLocal = nums[0];
        int n = nums.length;

        for(int i = 1; i<n; i++) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            max = Math.max(max, maxLocal);
        }

        return max;
    }
}