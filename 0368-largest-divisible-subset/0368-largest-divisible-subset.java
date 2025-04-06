class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, maxi = 0;
        int[] dp = new int[n];
        int[] prev = new int[n];

        List<Integer> ans = new ArrayList<>();

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > dp[maxi]) maxi = i;
        }

        for(int i = maxi; i>=0; i = prev[i]) {
            ans.add(nums[i]);
            if(prev[i] == -1) break;
        }

        return ans;
    }
}