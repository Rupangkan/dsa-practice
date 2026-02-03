class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int c = 1;
        if(nums[0] >= nums[1]) return false;

        for(int i = 2; i<n; i++) {
            if(nums[i-1] == nums[i]) return false;
            if((nums[i-2]-nums[i-1]) * (nums[i-1]-nums[i]) < 0) c++;
        }
        return c == 3;
    }
}