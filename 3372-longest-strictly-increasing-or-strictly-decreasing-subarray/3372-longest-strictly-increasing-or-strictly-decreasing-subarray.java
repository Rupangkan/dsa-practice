class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1, inc = 1, dec = 1, n = nums.length;

        for(int i = 0; i<n-1; i++) {
            if(nums[i + 1] > nums[i]) {
                inc++;
                dec = 1;
            } else if(nums[i + 1] < nums[i]) {
                dec++;
                inc = 1;
            } else {
                dec = 1;
                inc = 1;
            }

            max = Math.max(max, Math.max(dec, inc));
        }

        return max;
    }
}