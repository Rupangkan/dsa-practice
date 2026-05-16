class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int last = nums[n];

        int l = 0, r = n;

        while (l < n && nums[l] == last) l++;

        while (l < r) {
            int m = (l + r) >> 1;

            if (nums[m] > last) l = m + 1;
            else r = m;
        }

        return nums[l];
    }
}