class Solution {
    public boolean isPowerOfTwo(int n) {
        int x = 1;
        while(x<=n) {
            if(x == n) return true;
            if(x >= Integer.MAX_VALUE/2) break;
            x = x<<1;
        }
        return false;
    }
}