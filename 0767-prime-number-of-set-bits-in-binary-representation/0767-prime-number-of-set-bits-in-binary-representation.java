class Solution {
    private boolean prime(int x) {
        return x == 2 || x == 3 || x == 5 || x == 7 ||
               x == 11 || x == 13 || x == 17 || x == 19;
    }
    
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int v = L; v <= R; v++) {
            int bits = Integer.bitCount(v);
            if (prime(bits)) res++;
        }
        return res;
    }
}
