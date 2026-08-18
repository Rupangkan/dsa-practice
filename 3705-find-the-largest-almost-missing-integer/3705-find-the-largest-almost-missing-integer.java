class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (n == k) {
            int max = 0;
            for (int x : nums)
                max = Math.max(max, x);
            return max;
        }

        int[] freq = new int[51];
        for (int x : nums)
            freq[x]++;

        if (k == 1) {
            for (int x = 50; x >= 0; x--)
                if (freq[x] == 1)
                    return x;
            return -1;
        }

        int ans = -1;
        if (freq[nums[0]] == 1)
            ans = nums[0];
        if (freq[nums[n - 1]] == 1)
            ans = Math.max(ans, nums[n - 1]);

        return ans;
    }
}