class Solution {

    public int minDeletionSize(String[] a) {
        int n = a.length, m = a[0].length(), ans = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (a[i].charAt(j) < a[i - 1].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
