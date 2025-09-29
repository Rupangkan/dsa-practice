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

    public int findDuplicate(int[] nums) {
        return test(nums);
    }
}