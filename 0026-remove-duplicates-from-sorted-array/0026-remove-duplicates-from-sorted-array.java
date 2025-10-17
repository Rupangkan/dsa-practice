class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i<n; i++) {
            set.add(nums[i]);
        }
        int idx = 0;
        for(int i: set) {
            nums[idx] = i;
            idx++;
        }

        return set.size();
    }
}