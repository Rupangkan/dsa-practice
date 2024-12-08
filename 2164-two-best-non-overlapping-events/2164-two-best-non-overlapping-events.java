class Solution {
    int solve(int idx, int count, int[][] events, int[][] dp) {
        if(count == 2 || idx >= events.length) return 0;
        if(dp[idx][count] != -1) return dp[idx][count];

        int end = events[idx][1];
        int l = idx + 1, h = events.length - 1;
        while(l<h) {
            int mid = (l + h)/2;
            if(events[mid][0]>end) h = mid;
            else l = mid + 1;
        }
        int inc = events[idx][2] + (l < events.length && events[l][0] > end ? solve(l, count + 1, events, dp) : 0);
        int exc = solve(idx+1, count, events, dp);
        return dp[idx][count] = Math.max(inc, exc);
    }

    public int maxTwoEvents(int[][] events) {
        int[][] dp = new int[events.length][3];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solve(0, 0, events, dp);
    }
}