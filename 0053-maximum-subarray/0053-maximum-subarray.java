class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], n = nums.length;
        int maxLocal = nums[0];
        
        for(int i = 1; i<n; i++) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            max = Math.max(maxLocal, max);
        }
        return max;
    }
}