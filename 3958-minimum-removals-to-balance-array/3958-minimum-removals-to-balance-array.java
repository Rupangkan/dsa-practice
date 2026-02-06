class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = n, r = 0;

        for(int l = 0; l<n; l++) {
            while(r < n && nums[r] <= (long) nums[l] * k) r++;
            ans = Math.min(ans, n - (r - l));
        }

        return ans;
    }
}