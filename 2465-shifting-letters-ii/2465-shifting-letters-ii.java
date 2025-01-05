class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
   int n = s.length();
        int[] diff = new int[n];

        for (int[] sh : shifts) {
            diff[sh[0]] += sh[2] == 1 ? 1 : -1;
            if (sh[1] + 1 < n) diff[sh[1] + 1] += sh[2] == 1 ? -1 : 1;
        }

        StringBuilder res = new StringBuilder(s);
        int shift = 0;

        for (int i = 0; i < n; i++) {
            shift = (shift + diff[i]) % 26;
            if (shift < 0) shift += 26;
            res.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + shift) % 26));
        }

        return res.toString();
    }
}