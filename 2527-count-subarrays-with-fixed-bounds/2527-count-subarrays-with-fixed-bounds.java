class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int s = -1, min = -1, max = -1, n = nums.length;
        long count = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] < minK || nums[i] > maxK) s = i;
            if(nums[i] == maxK) max = i;
            if(nums[i] == minK) min = i;
            int isVal = Math.max(0, Math.min(min, max) - s);
            count += isVal;
        }

        return count;
    }
}