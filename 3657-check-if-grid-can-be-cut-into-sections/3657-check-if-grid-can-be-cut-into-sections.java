class Solution {

    boolean check(int[][] r, int d) {
        int gc = 0;
        Arrays.sort(r, (a, b) -> Integer.compare(a[d], b[d]));
        int fe = r[0][d + 2];

        for(int i = 0; i<r.length; i++) {
            int[] rect = r[i];
            if(fe <= rect[d]) gc++;
            fe = Math.max(fe, rect[d + 2]);
        }

        return gc >= 2;
    }

    public boolean checkValidCuts(int n, int[][] r) {
        return check(r, 0) || check(r, 1);
    }
}