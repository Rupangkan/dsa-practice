class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int profit = 0;

        for(int i = 0; i<n; i++) {
            int sell = nums[i] - min;
            min = Math.min(min, nums[i]);
            profit = Math.max(profit, sell); 
        }

        return profit;
    }
}