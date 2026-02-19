class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int res = 0, last = 0, run = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                run++;
            } else {
                res += last < run ? last : run;
                last = run;
                run = 1;
            }
        }

        res += last < run ? last : run;
        return res;
    }
}
