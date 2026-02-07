class Solution {

    public int minimumDeletions(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a++;
        }

        int b = 0;
        int ans = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a--;
            ans = Math.min(ans, a + b);
            if (s.charAt(i) == 'b') b++;
        }

        return ans;
    }
}
