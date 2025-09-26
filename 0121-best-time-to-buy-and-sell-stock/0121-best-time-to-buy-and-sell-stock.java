class Solution {
    private int optimal(int[] p) {
        int n = p.length;
        int mini = p[0], profit = 0;

        for(int i = 0; i<n; i++) {
            int sell = p[i] - mini;
            profit = Math.max(profit, sell);
            mini = Math.min(mini, p[i]); 
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return optimal(prices);
    }
}