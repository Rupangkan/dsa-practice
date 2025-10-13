class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int i = 0; i<n; i++) {
            set.add(nums[i]);
        }

        for(int curr: set) {
            int count = 1;
            if(!set.contains(curr - 1)) {
                while(set.contains(curr + 1)) {
                    count++;
                    curr = curr + 1;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}