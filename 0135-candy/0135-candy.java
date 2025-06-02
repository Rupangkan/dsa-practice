class Solution {

    private int solve(int[] a) {
        int n = a.length, res = 0;
        int[] c = new int[n];
        Arrays.fill(c, 1);
        for (int i = 1; i < n; i++) 
            if (a[i] > a[i - 1]) c[i] = c[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) c[i] = Math.max(c[i], c[i + 1] + 1);
            res += c[i];
        }
        return res + c[n - 1];
    }

    public int candy(int[] ratings) {
        return solve(ratings);
    }
}