class Solution {
    public boolean checkDivisibility(int n) {
        int di = 0, diP = 1, or = n;

        while(n > 0) {
            int d = n % 10;
            n/=10;
            di += d;
            diP *= d;
        }
        return or % (di + diP) == 0;
    }
}