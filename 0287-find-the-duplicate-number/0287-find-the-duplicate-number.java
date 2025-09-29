class Solution {
    private int test(int[] nums) {
        int n = nums.length;
        Set<Integer> hs = new HashSet<>();

        for(int i = 0; i<n; i++) {
            if(hs.contains(nums[i])) return nums[i];
            hs.add(nums[i]);
        }
        return -1;
    }

    // slow and fast pointer approach needed
    private int optimal(int[] nums) {
        int n = nums.length;
        int slow = nums[0];
        int fast = nums[0];

        // while(slow != fast) {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // }
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public int findDuplicate(int[] nums) {
        // return test(nums);
        return optimal(nums);
    }
}