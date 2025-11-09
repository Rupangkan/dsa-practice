class Solution {
    // ON
    // ON
    private int brute(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(); 
        int idx = 0;

        for(int num: nums) {
            if(!set.contains(num)) {
                set.add(num);
                nums[idx] = num;
                idx++;
            } 
        }

        return set.size();
    }

    // ON
    // O1
    private int optimal(int[] nums) {
        int n = nums.length;
        int idx = 0;

        // 1, 1, 2, 2, 2, 3, 4,
        for(int i = 1; i<n; i++) {
            if(nums[i] != nums[idx]) {
                idx++;
                nums[idx] = nums[i];
            }
        }

        return idx + 1;
    }

    public int removeDuplicates(int[] nums) {
        // return brute(nums);
        return optimal(nums);
    }
}