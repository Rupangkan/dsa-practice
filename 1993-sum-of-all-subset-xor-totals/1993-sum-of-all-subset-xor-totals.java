class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        for(int n: nums) ans |= n;
        return ans << (nums.length - 1);
    }
}