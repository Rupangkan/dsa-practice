class Solution {

    public int reverse(int n) {
        int x = 0;
        while (n > 0) {
            x = x * 10 + n % 10;
            n /= 10;
        }
        return x;
    }

    public int mirrorDistance(int n) {
        int r = reverse(n);
        int d = n - r;
        return d < 0 ? -d : d;
    }
}