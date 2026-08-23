class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int[] left = count(num, 0, n / 2);
        int[] right = count(num, n / 2, n);

        int sum = left[0] - right[0];
        int q = left[1] - right[1];

        return ((left[1] + right[1]) & 1) == 1
            || sum != -q * 9 / 2;
    }

    private int[] count(String s, int l, int r) {
        int sum = 0, q = 0;

        for (int i = l; i < r; i++) {
            if (s.charAt(i) == '?')
                q++;
            else
                sum += s.charAt(i) - '0';
        }

        return new int[] { sum, q };
    }
}