class Solution {

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pre = 0;

        for (int i = 0; i < n; i++) {
            ans[i] = pre;
            pre += nums[i];
        }

        int suf = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - suf);
            suf += nums[i];
        }

        return ans;
    }
}