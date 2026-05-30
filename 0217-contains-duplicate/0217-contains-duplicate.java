class Solution {
    // Time complexity : O(N) if used hashset since average time to search in hashset is O(1)
    // Space complexity : O(N)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}