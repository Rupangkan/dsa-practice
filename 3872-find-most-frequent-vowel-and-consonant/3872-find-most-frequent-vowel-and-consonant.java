class Solution {
    public int maxFreqSum(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        int v = 0, cns = 0;
        for (int i = 0; i < 26; i++) {
            if ("aeiou".indexOf(i + 'a') >= 0) v = Math.max(v, f[i]);
            else cns = Math.max(cns, f[i]);
        }
        return v + cns;
    }
}
