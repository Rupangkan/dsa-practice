class Solution {
    public int maximumDifference(int[] nums) {
        int max = -1;

        for(int i = 0; i<nums.length-1; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    int curr = Math.abs(nums[j] - nums[i]);
                    max = Math.max(max, curr);
                }
            }
        }

        return max;
    }
}