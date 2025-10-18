class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int idx = s.length-1, count = 0, n = g.length;
        for(int i = n-1; i>=0; i--) {
            if(idx >= 0 && g[i] <= s[idx]) {
                idx--;
                count++;
            }
        }

        return count;
    }
}