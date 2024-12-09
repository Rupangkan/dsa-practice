class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m = queries.length, n = nums.length;
        boolean[] ans = new boolean[m];

        int[] prefix = new int[n];
        prefix[0] = 0;

        for(int i = 1; i<n; i++) {
            if(nums[i] % 2 == nums[i-1] % 2) {
                prefix[i] = prefix[i-1]+1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }

        for(int i = 0; i<m; i++) {
            int[] q = queries[i];
            int s = q[0], e = q[1];

            ans[i] = prefix[e] - prefix[s] == 0;
        }

        return ans;
    }
}