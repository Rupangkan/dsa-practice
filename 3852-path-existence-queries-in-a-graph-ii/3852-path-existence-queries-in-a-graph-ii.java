class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        int[][] jump = new int[n][18];

        int r = 0;

        for (int i = 0; i < n; i++) {

            r = Math.max(r, i);

            while (
                r + 1 < n &&
                arr[r + 1][0] - arr[r][0] <= maxDiff &&
                arr[r + 1][0] - arr[i][0] <= maxDiff
            ) {
                r++;
            }

            jump[i][0] = r;
        }

        for (int j = 1; j < 18; j++) {
            for (int i = 0; i < n; i++) {
                jump[i][j] = jump[jump[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (u == v) {
                continue;
            }

            int cur = u;
            int steps = 0;

            for (int j = 17; j >= 0; j--) {
                if (jump[cur][j] < v) {
                    cur = jump[cur][j];
                    steps += 1 << j;
                }
            }

            ans[i] = jump[cur][0] >= v ? steps + 1 : -1;
        }

        return ans;
    }
}