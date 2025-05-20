class Solution {
    
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] neg = new int[n+1];

        for(int[] q: queries) {
            int l = q[0], r = q[1];
            neg[l] += 1;
            if(r+1 <n) neg[r+1] -= 1;
        }

        for(int i = 1; i<n; i++) {
            neg[i] += neg[i-1];
        }

        for(int i = 0; i<n; i++) {
            if(nums[i] > neg[i]) return false;
        }

        return true;
    }
}