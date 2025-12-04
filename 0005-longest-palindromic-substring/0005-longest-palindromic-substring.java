class Solution {
    private String optimal(String s) {
        String ans = "";
        int len = 0, n = s.length();

        for(int i = 0; i<n; i++) {
            int left = i, right = i;
            // odd length
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        return ans;
    }

    public String longestPalindrome(String s) {
        return optimal(s);
    }
}