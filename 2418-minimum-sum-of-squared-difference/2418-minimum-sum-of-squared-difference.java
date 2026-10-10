class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1 + k2, max = 0;

        for (int i = 0; i < n; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, nums1[i]);
        }

        int l = 0, r = max, res = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            long need = 0;

            for (int num : nums1)
                need += Math.max(0, num - mid);

            if (need <= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        for (int num : nums1)
            if (num > res) k -= num - res;

        Arrays.sort(nums1);
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            long diff = Math.min(nums1[i], res);
            if (k > 0 && diff > 0) {
                diff--;
                k--;
            }
            ans += diff * diff;
        }

        return ans;
    }
}