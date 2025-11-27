class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        long[] minPrefix = new long[k];
        long sum = Long.MIN_VALUE;
        
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        
        for(int i = 0; i<n; i++) {
            prefix[i+1] = nums[i] + prefix[i];
        }

        for(int i = 0; i<=n; i++) {
            int rem = i%k;
            if(i >= k) sum = Math.max(sum, prefix[i] - minPrefix[rem]);
            minPrefix[rem] = Math.min(minPrefix[rem], prefix[i]);
        }

        return sum == Long.MIN_VALUE ? 0 : sum;
    }
}