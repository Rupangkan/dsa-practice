class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;

        ans[left] = nums[0];
        ans[right] = nums[1];

        for (int i = 2; i < n; i++) {
            if (ans[left] > ans[right])
                ans[++left] = nums[i];
            else
                ans[--right] = nums[i];
        }

        for (int l = right, r = n - 1; l < r; l++, r--) {
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
        }

        return ans;
    }
}