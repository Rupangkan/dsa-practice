class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int cur = 0;
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cur = ((cur << 1) + nums[i]) % 5;
            ans.add(cur == 0);
        }
        return ans;
    }
}
