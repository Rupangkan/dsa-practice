class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1_000_000_007;
        int[] count = new int[30];

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0)
                    count[i]++;
            }
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 29; j >= 0; j--) {
                if (count[j] > 0) {
                    num |= 1L << j;
                    count[j]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}