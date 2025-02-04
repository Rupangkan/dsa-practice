class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0, currSub = nums[0], n = nums.length;

        for(int i = 1; i<n; i++) {
            if(nums[i] <= nums[i - 1]) {
                max = Math.max(max, currSub);
                currSub = 0;
            } 
            currSub += nums[i];
        }

        return Math.max(max, currSub);
    }
}