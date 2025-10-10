class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        int n = energy.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for(int i = n-1; i>=0; i--) {
            // int curr = Integer.MIN_VALUE;
            if(i+k>=n) {
                dp[i] = energy[i];
            } else {
                dp[i] = dp[i+k]+energy[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}