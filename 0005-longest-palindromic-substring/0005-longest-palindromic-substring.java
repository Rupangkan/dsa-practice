class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String ans = "";
        if(n == 1) return s;

        for(int i = 0; i<n; i++) {
            int l = i, r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    ans = s.substring(l, r+1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    ans = s.substring(l, r+1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }  
}