class Solution {
    public int countHillValley(int[] nums) {
        int c = 0, l = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if ((nums[i] > nums[l] && nums[i] > nums[i + 1]) || 
                    (nums[i] < nums[l] && nums[i] < nums[i + 1])) {
                    c++;
                }
                l = i;
            }
        }
        return c;
    }
}