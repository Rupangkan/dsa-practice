class Solution {
    private int solve(int[] nums, int t) {
        int m = (int) 1e9 + 7, n = nums.length;
        Arrays.sort(nums);
        int[] p = new int[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) p[i] = (p[i - 1] << 1) % m;

        int l = 0, r = n - 1, res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= t) {
                res = (res + p[r - l]) % m;
                l++;
            } else r--;
        }
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        return solve(nums, target);
    }
}