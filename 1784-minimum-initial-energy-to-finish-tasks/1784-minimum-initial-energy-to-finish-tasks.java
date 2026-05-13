class Solution {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        int ans = 0, cur = 0;

        for (int[] t : tasks) {
            int actual = t[0], need = t[1];

            if (cur < need) {
                ans += need - cur;
                cur = need;
            }

            cur -= actual;
        }

        return ans;
    }
}