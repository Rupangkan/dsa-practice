class Solution {
    public void reverseString(char[] s) {
        int n = s.length, r = n-1;
        for(int i = 0; i<n/2; i++) {
            s[i] += (char)s[r];
            s[r] = (char)(s[i] - s[r]);
            s[i] -= s[r];
            r--;
        }
    }
}