class Solution {
    public int minimumOneBitOperations(int n) {
        if(n == 0) return 0;
        int p = 1;
        while((p<<1) <= n) p <<= 1;
        return (p<<1) - 1 - minimumOneBitOperations(n ^ p);
    }
}
