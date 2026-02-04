class Solution {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long best = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) j++;
            int p = j - 1;
            if (p == i) continue;

            long cur = nums[p] + nums[p - 1];
            while (j < n && nums[j] < nums[j - 1]) {
                cur += nums[j];
                j++;
            }
            int q = j - 1;
            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
                i = q;
                continue;
            }

            cur += nums[q + 1];

            long add = 0, mx = 0;
            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
                add += nums[k];
                mx = Math.max(mx, add);
            }
            cur += mx;

            add = 0;
            mx = 0;
            for (int k = p - 2; k >= i; k--) {
                add += nums[k];
                mx = Math.max(mx, add);
            }
            cur += mx;

            best = Math.max(best, cur);
            i = q - 1;
        }

        return best;
    }
}
