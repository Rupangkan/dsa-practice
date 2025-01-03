class Solution {
    public int waysToSplitArray(int[] nums) {
        long lSum = 0, rSum = 0, c = 0;

        for(int n: nums) {
            rSum += n;
        }

        for(int i = 0; i<nums.length-1; i++) {
            lSum += nums[i];
            rSum -= nums[i];
            if(lSum >= rSum) {
                c++;
            }
        }

        return (int)c;
    }
}