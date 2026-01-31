class Solution {
    public char nextGreatestLetter(char[] a, char t) {
        int l = 0, r = a.length - 1;
        if (a[r] <= t) return a[0];
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] > t) r = m;
            else l = m + 1;
        }
        return a[l];
    }
}
