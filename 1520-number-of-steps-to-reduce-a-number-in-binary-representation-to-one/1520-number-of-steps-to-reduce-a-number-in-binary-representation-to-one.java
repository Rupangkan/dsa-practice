class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int ops = 0;
        int carry = 0;

        for (int i = n - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if ((bit & 1) == 1) {
                ops += 2;
                carry = 1;
            } else {
                ops += 1;
            }
        }

        return ops + carry;
    }
}
