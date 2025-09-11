class Solution {
    boolean v(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }
    public String sortVowels(String s) {
        int[] f = new int[128];
        for (char c : s.toCharArray()) if (v(c)) f[c]++;
        String p = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (char c : s.toCharArray()) {
            if (!v(c)) sb.append(c);
            else {
                while (f[p.charAt(j)] == 0) j++;
                sb.append(p.charAt(j));
                f[p.charAt(j)]--;
            }
        }
        return sb.toString();
    }
}
