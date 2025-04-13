class Solution {
    long solve(int x, long y) {
        long r = 1, m = x;

        while(y > 0) {
            if(y % 2 == 1) r = (r * m) % 1000000007;
            m = (m * m) % 1000000007;
            y /= 2;
        }

        return r;
    }

    public int countGoodNumbers(long n) {
        return (int) ((solve(5, (n + 1)/2) * solve(4, n/2)) % 1000000007);
    }
}