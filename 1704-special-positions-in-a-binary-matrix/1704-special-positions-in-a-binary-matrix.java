class Solution {
    public int numSpecial(int[][] a) {
        int m = a.length, n = a[0].length;
        int[] r = new int[m], c = new int[n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }

        int ans = 0;
        for (int i = 0; i < m; i++)
            if (r[i] == 1)
                for (int j = 0; j < n; j++)
                    if (a[i][j] == 1 && c[j] == 1)
                        ans++;

        return ans;
    }
}
