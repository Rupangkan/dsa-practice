class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num), t = s;
        int p = 0;

        while(p < s.length() && s.charAt(p) == '9') p++;
        if(p < s.length()) s = s.replace(s.charAt(p), '9');
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}