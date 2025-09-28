class Solution {
    public int maxSubArray(int[] nums) {
        int maxLocal = nums[0];
        int max = nums[0];
        int n = nums.length;

        for(int i = 1; i<n; i++) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            max = Math.max(maxLocal, max);
        }
        return max;
    }
}