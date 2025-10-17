class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, n = nums.length;
        int count = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) {
                max = Math.max(max, count);
                count = 0;
            } else if (i == n-1) {
                count++;
                max = Math.max(count, max);
            } else {
                count++;
            }
        }

        return max;
    }
}