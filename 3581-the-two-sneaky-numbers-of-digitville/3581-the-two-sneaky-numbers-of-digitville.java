class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i = 0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                if(ans[0] == -1) {
                    ans[0] = nums[i];
                } else {
                    ans[1] = nums[i];
                }
            } else {
                set.add(nums[i]);
            }
        }
        return ans;
    }
}