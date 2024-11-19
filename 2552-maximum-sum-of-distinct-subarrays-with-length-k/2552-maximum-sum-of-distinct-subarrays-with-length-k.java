class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length, l = 0, r = 0;
        long ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r<n) {
            int last = map.getOrDefault(nums[r], -1);
            while(l <= last || r - l + 1 > k) {
                sum -= nums[l];
                l++;
            }
            map.put(nums[r], r);
            sum += nums[r];

            if(r - l + 1 == k) {
                ans = Math.max(ans, sum);
            }
            r++;
        }
        return ans;

    }
}