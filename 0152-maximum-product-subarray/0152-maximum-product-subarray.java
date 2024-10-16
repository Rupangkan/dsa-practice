class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = nums[0];

        for(int i = 0; i<nums.length; i++) {
            int temp = max * nums[i];
            max = Math.max(nums[i], Math.max(temp, nums[i] * min));
            min = Math.min(nums[i], Math.min(temp, nums[i] * min));
            res = Math.max(res, max);
        }

        return res;
    }
}