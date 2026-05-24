class Solution {

    int[] dp;

    void solve(int[] arr, int i, int d) {
        if (dp[i] != -1) return;

        dp[i] = 1;
        int n = arr.length;

        for (int j = i - 1; j >= 0 && i - j <= d && arr[j] < arr[i]; j--) {
            solve(arr, j, d);
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        for (int j = i + 1; j < n && j - i <= d && arr[j] < arr[i]; j++) {
            solve(arr, j, d);
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            solve(arr, i, d);
        }

        int ans = 0;

        for (int x : dp) {
            ans = Math.max(ans, x);
        }

        return ans;
    }
}