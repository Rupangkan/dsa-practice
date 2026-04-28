class Solution {

    public int minOperations(int[][] grid, int x) {
        List<Integer> a = new ArrayList<>();
        int base = grid[0][0] % x;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != base) return -1;
                a.add(grid[i][j]);
            }
        }

        Collections.sort(a);

        int n = a.size();
        int l = 0, r = n - 1, ans = 0;

        while (l < r) {
            if (l < n - r - 1) {
                int d = a.get(l + 1) - a.get(l);
                ans += (l + 1) * (d / x);
                l++;
            } else {
                int d = a.get(r) - a.get(r - 1);
                ans += (n - r) * (d / x);
                r--;
            }
        }

        return ans;
    }
}