class Solution {

    public int countTriples(int n) {
        int ans = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int val = a * a + b * b;
                int c = (int) Math.sqrt(val);

                if (c <= n && c * c == val) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
