class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long n = nums.length, sum = 0, ans = 1, j = 0;
        // int i = 0, j = 0;

        for(int i = 0; i<n; i++) {
            sum += nums[i];
            long invalid = (i-j+1)*nums[i]-sum;
            if(invalid > k) {
                sum -= nums[(int)j++];
                invalid = (i-j+1)*nums[i]-sum;
            }
            ans = Math.max(ans, i-j+1);
        }
        return (int)ans;
    }
}