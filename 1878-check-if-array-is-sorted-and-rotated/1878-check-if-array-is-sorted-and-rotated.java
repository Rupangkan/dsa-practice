class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, inv = 0;
        if(n <= 1) return true;

        for(int i = 1; i<n; i++) {
            if(nums[i] < nums[i-1]) inv++;
        }

        if(nums[0] < nums[n-1]) inv++;

        return inv <= 1;
    }
}