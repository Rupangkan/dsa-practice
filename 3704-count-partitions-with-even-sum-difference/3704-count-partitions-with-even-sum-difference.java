class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum1 = 0, count = 0;

        for(int i = 0; i<n-1; i++) {
            sum1 += nums[i];
            int sum2 = 0;
            for(int j = i+1; j<n; j++) {
                sum2 += nums[j];
            }
            if((sum1 - sum2) % 2 == 0) count++;
        }
        return count;
    }
}