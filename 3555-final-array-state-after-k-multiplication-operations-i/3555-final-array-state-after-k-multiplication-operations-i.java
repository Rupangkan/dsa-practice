class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        // int ind = -1, tempNo = 0;
        // int min = Integer.MAX_VALUE;
        int l = 0;

        for(int j = 0; j<k; j++) {
            int ind = -1;
            int tempNo = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++) {
                if(nums[i]<min) {
                    ind = i;
                    tempNo = nums[i];
                    min = nums[i];
                }
            }
            nums[ind] = tempNo * multiplier;
        }
        return nums;
    }
}