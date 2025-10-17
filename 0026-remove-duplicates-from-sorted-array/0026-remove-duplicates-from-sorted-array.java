class Solution {
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
    public int removeDuplicates(int[] nums) {
        return brute(nums);
    }
}