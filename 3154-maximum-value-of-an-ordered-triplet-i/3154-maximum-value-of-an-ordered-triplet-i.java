class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0, max = 0, maxD = 0;

        for(int i = 0; i<n; i++) {
            ans = Math.max(ans, maxD * nums[i]);
            maxD = Math.max(maxD, max - nums[i]);
            max = Math.max(max, nums[i]);
        }

        return ans;
    }
}