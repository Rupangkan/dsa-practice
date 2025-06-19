class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, part = nums[0], n = nums.length;

        for(int i = 0; i<n; i++) {
            if(nums[i] - part > k) {
                ans++;
                part = nums[i];
            }
        }
        return ans;
    }
}