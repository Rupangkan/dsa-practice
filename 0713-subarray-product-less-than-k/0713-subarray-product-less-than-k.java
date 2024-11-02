class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length, count = 0;
        long prod = 1;

        while(r<n) {
            prod *= nums[r];
            while(l<=r && prod >= k) {
                prod /= nums[l];
                l++;
            }
            count += (r-l)+1;
            r++;
        }
        return count;
    }
}