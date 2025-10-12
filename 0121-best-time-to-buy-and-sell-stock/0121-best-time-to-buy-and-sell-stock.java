class Solution {
    public int maxProfit(int[] nums) {
        int profit = 0;
        int mini = nums[0];
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int sell = nums[i] - mini;
            profit = Math.max(profit, sell);
            mini = Math.min(mini, nums[i]);
        }

        return profit;
    }
}