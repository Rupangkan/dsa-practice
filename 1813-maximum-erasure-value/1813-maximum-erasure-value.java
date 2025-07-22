class Solution {
    private int solve(int[] a) {
        int n = a.length, sum = 0, ans = 0, l = 0;
        boolean[] seen = new boolean[10001];
        for (int r = 0; r < n; r++) {
            while (seen[a[r]]) {
                sum -= a[l];
                seen[a[l++]] = false;
            }
            sum += a[r];
            seen[a[r]] = true;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maximumUniqueSubarray(int[] nums) {
        return solve(nums);
    }
}