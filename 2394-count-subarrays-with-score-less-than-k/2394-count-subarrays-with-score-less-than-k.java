class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0, count = 0;
        for(int i = 0, j = 0; j<n; j++) {
            count += nums[j];
            while(i <= j && count * (j - i + 1) >= k) {
                count -= nums[i];
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}