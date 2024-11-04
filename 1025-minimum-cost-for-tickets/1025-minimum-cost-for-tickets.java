class Solution {
    int solveRecur(int curr, int[] days, int[] costs, Set<Integer> set, int[] dp) {
        if(curr > days[days.length-1]) return 0;

        if(dp[curr] != -1) return dp[curr];

        if(!set.contains(curr)) return solveRecur(curr+1, days, costs, set, dp);

        int pick1 = costs[0]+solveRecur(curr+1, days, costs, set, dp);
        int pick7 = costs[1]+solveRecur(curr+7, days, costs, set, dp);
        int pick30 = costs[2]+solveRecur(curr+30, days, costs, set, dp);

        return dp[curr] =  Math.min(pick1, Math.min(pick7, pick30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length, m = costs.length, last = days[n-1];
        int[] dp = new int[last+1];
        // Arrays.fill(dp, -1);
        int[] daysGone = new int[] {1, 7, 30};

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++) set.add(days[i]);

        int c = 0;

        for(int i = 1; i<=last; i++) {
            if(i < days[c]) {
                dp[i] = dp[i-1];
                continue;
            }
            c++;
            int day30 = 30, day7 = 7, day1 = 1;
            // if(i+day1 > last) day1 = last;
            // if(i+day7 > last) day7 = last;
            // if(i+day30 > last) day30 = last;
            dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1],
                                dp[Math.max(0, i - 30)] + costs[2]));
        }
        System.out.println(Arrays.toString(dp));
        return dp[last];
        // return solveRecur(1, days, costs, set, dp);
    }
}