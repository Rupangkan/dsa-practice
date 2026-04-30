class Solution {
    public int maxProfit(int[] nums) {
        int profit = 0;
        int buyPrice = nums[0];
        int n = nums.length;

        for(int i = 1; i<n; i++) {
            int sell = nums[i] - buyPrice;
            profit = Math.max(profit, sell);
            buyPrice = Math.min(buyPrice, nums[i]);
        }

        return profit;
    }
}