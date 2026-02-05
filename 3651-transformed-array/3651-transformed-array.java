class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        for(int i = 0; i<n; i++) {
            int curr = nums[i];
            if(nums[i] == 0) {
                res[i] = curr;
            } else {
                int t = (i + curr % n + n) % n;
                
                res[i] = nums[t];
            }
        }
        return res;
    }
}