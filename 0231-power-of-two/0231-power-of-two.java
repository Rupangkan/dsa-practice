class Solution {
    boolean isPow2(int n) {
        return (n&(n-1)) == 0;
    }
    public boolean isPowerOfTwo(int n) {
        // int x = 1;
        // while(x<=n) {
        //     if(x == n) return true;
        //     if(x >= Integer.MAX_VALUE/2) break;
        //     x = x<<1;
        // }
        // return false;
        if(n <= 0) return false;
        return isPow2(n);
    }
}