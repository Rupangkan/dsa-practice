class Solution {
    private int optimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // s - 4, 2. 3, 4
        // f - 2, 4, 3, 2

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0]; // 2

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        return optimal(nums);
    }
}